package com.example.smartfarm;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartfarm.Model.Tanaman;
import com.example.smartfarm.Model.getTanaman;
import com.example.smartfarm.Model.PushPutDelTanaman;
import com.example.smartfarm.Rest.ApiClient;
import com.example.smartfarm.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detail extends AppCompatActivity {

    private Button btnHapus, btnClose;
    private TextView namaTanaman, posisi, umur, kadarAir, kadarPH;
    private ImageView gambar, btnAction, btnCekAir, btnCekPH;

    private int umurInt, idInt;
    private String id_tanaman, nama_tanaman, posisi_tanaman, gcode, umur_tanaman, kadar_air, suhu, status;
    private String updateHari, updateStatus, message, idTampil;

    ApiInterface mApiInterface;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initComponents();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        this.mHandler = new Handler();
        m_Runnable.run();

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.equals("kosong")){
                    updateStatus = "aktif";
                    updateHari = "1";
                    umur.setText("Umur : "+updateHari+" hari");
                    gambar.setImageResource(R.drawable.p1);
                    btnAction.setImageResource(R.drawable.siram);
                    message = "penanaman";
                }else if(status.equals("siram")){
                    updateStatus = "aktif";
                    message = "penyiraman";
                }else if(status.equals("panen")){
                    updateStatus = "kosong";
                    updateHari = "0";
                    message = "pemanenan";
                    umur.setText("Umur : "+updateHari+" hari");
                    gambar.setImageResource(R.drawable.p0);
                    btnAction.setImageResource(R.drawable.tanam);
                    kadar_air = "0";
                    suhu = "0";
                }
                Call<PushPutDelTanaman> aksiTanaman = mApiInterface.putTanaman(
                        id_tanaman,
                        nama_tanaman,
                        posisi_tanaman,
                        gcode,
                        updateHari,
                        kadar_air,
                        suhu,
                        updateStatus
                );
                aksiTanaman.enqueue(new Callback<PushPutDelTanaman>() {
                    @Override
                    public void onResponse(Call<PushPutDelTanaman> call, Response<PushPutDelTanaman> response) {
                        Toast.makeText(detail.this, "melakukan "+message, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<PushPutDelTanaman> call, Throwable t) {
                        Toast.makeText(detail.this, "gagal update data", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

    private final Runnable m_Runnable = new Runnable() {
        public void run() {
            refresh();
            detail.this.mHandler.postDelayed(m_Runnable,10000);
        }

    };

    public void refresh(){
        final Call<getTanaman> getData = mApiInterface.getTanaman();
        getData.enqueue(new Callback<getTanaman>() {
                            @Override
                            public void onResponse(Call<getTanaman> call, Response<getTanaman> response) {
                                final List<Tanaman> TanamanList = response.body().getListDataTanaman();
                                getExtrasData(TanamanList);
                                namaTanaman.setText("Tanaman " + id_tanaman);
                                umur.setText("Umur : "+umur_tanaman+" hari");
                                kadarAir.setText("Kadar Air : "+kadar_air+"%");
                                kadarPH.setText("Suhu : "+suhu+"C");

                                umurInt = Integer.parseInt(umur_tanaman);

                                if (umurInt <= 0){
                                    gambar.setImageResource(R.drawable.p0);
                                    btnAction.setImageResource(R.drawable.tanam);
                                }else if (umurInt >= 1 && umurInt <= 3){
                                    gambar.setImageResource(R.drawable.p1);
                                    kondisiButton();
                                }else if (umurInt >= 4 && umurInt <= 5){
                                    gambar.setImageResource(R.drawable.p2);
                                    kondisiButton();
                                }else if (umurInt >= 6 && umurInt <= 8){
                                    gambar.setImageResource(R.drawable.p3);
                                    kondisiButton();
                                }else if (umurInt >= 9 && umurInt <= 11){
                                    gambar.setImageResource(R.drawable.p4);
                                    kondisiButton();
                                }else if (umurInt >= 12 && umurInt <= 15){
                                    gambar.setImageResource(R.drawable.p5);
                                    kondisiButton();
                                }else if (umurInt >= 16 && umurInt < 30){
                                    gambar.setImageResource(R.drawable.p6);
                                    kondisiButton();
                                }else if (umurInt >= 30){
                                    gambar.setImageResource(R.drawable.p7);
                                    btnAction.setImageResource(R.drawable.panen);
                                }
                            }

                            @Override
                            public void onFailure(Call<getTanaman> call, Throwable t) {
                                Toast.makeText(detail.this, "data tidak terhubung", Toast.LENGTH_SHORT).show();
                            }
                        });

    }

    private void kondisiButton(){
        if(status.equals("siram")){
            btnAction.setEnabled(true);
            btnAction.setImageResource(R.drawable.siram);
        }else{
            btnAction.setEnabled(false);
            btnAction.setImageResource(R.drawable.siram_disable);
        }
    }

    private void getExtrasData(List<Tanaman> TanamanList){
        Bundle bundle   = getIntent().getExtras();
        id_tanaman      = bundle.getString("Id_tanaman");
        idInt           = Integer.parseInt(id_tanaman);
        idTampil        = String.valueOf(idInt+1);
        nama_tanaman    = TanamanList.get(idInt).getNama();
        posisi_tanaman  = TanamanList.get(idInt).getPosisi();
        gcode           = TanamanList.get(idInt).getGcode();
        umur_tanaman    = TanamanList.get(idInt).getUmur_tanaman();
        kadar_air       = TanamanList.get(idInt).getKadar_air();
        suhu            = TanamanList.get(idInt).getSuhu();
        status          = TanamanList.get(idInt).getStatus();
    }

    private void initComponents(){
        btnCekAir   = (ImageView) findViewById(R.id.btnCekAir);
        btnCekPH    = (ImageView) findViewById(R.id.btnCekPH);
        btnAction   = (ImageView) findViewById(R.id.btnAction);
        namaTanaman = (TextView) findViewById(R.id.posisiTanaman);
        umur        = (TextView) findViewById(R.id.umurTanaman);
        kadarAir    = (TextView) findViewById(R.id.kadarAir);
        kadarPH     = (TextView) findViewById(R.id.kadarPH);
        gambar      = (ImageView)findViewById(R.id.gambarTanaman);
    }

    public  void onBackPressed(){
        MainActivity.ma.refesh();
        finish();
    }
}
