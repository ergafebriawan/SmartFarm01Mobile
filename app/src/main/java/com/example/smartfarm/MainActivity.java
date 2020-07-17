package com.example.smartfarm;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartfarm.Model.Tanaman;
import com.example.smartfarm.Model.getTanaman;
import com.example.smartfarm.Rest.ApiClient;
import com.example.smartfarm.Rest.ApiInterface;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView user;
    private ImageView btnTanaman1, btnTanaman2, btnTanaman3, btnTanaman4, btnTanaman5, btnTanaman6;

    private long exitTime = 0;
    public static MainActivity ma;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        ma = this;
        this.mHandler = new Handler();
        m_Runnable.run();
    }

    private final Runnable m_Runnable = new Runnable() {
        public void run() {
            refesh();
            MainActivity.this.mHandler.postDelayed(m_Runnable,10000);
        }

    };

    private void initComponents(){
        btnTanaman1 = (ImageView)findViewById(R.id.btnTanaman1);
        btnTanaman2 = (ImageView)findViewById(R.id.btnTanaman2);
        btnTanaman3 = (ImageView)findViewById(R.id.btnTanaman3);
        btnTanaman4 = (ImageView)findViewById(R.id.btnTanaman4);
        btnTanaman5 = (ImageView)findViewById(R.id.btnTanaman5);
        btnTanaman6 = (ImageView)findViewById(R.id.btnTanaman6);
    }

    public void refesh(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        final Call<getTanaman> result = apiService.getTanaman();
        result.enqueue(new Callback<getTanaman>() {
            @Override
            public void onResponse(Call<getTanaman> call, Response<getTanaman> response) {
                final List<Tanaman> TanamanList = response.body().getListDataTanaman();
                //Toast.makeText(MainActivity.this, "data terhubung", Toast.LENGTH_SHORT).show();

                int umurPlant1 = Integer.parseInt(TanamanList.get(0).getUmur_tanaman());
                int umurPlant2 = Integer.parseInt(TanamanList.get(1).getUmur_tanaman());
                int umurPlant3 = Integer.parseInt(TanamanList.get(2).getUmur_tanaman());
                int umurPlant4 = Integer.parseInt(TanamanList.get(3).getUmur_tanaman());
                int umurPlant5 = Integer.parseInt(TanamanList.get(4).getUmur_tanaman());
                int umurPlant6 = Integer.parseInt(TanamanList.get(5).getUmur_tanaman());

                iconButtonPlan(btnTanaman1, umurPlant1);
                iconButtonPlan(btnTanaman2, umurPlant2);
                iconButtonPlan(btnTanaman3, umurPlant3);
                iconButtonPlan(btnTanaman4, umurPlant4);
                iconButtonPlan(btnTanaman5, umurPlant5);
                iconButtonPlan(btnTanaman6, umurPlant6);

                btnTanaman1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        senData(0, TanamanList);
                    }
                });

                btnTanaman2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        senData(1, TanamanList);
                    }
                });

                btnTanaman3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        senData(2, TanamanList);
                    }
                });

                btnTanaman4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        senData(3, TanamanList);
                    }
                });

                btnTanaman5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        senData(4, TanamanList);
                    }
                });

                btnTanaman6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        senData(5, TanamanList);
                    }
                });
            }
            @Override
            public void onFailure(Call<getTanaman> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "data tidak terhubung", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void iconButtonPlan(ImageView gambar, int umurInt){
        if (umurInt <= 0){
            gambar.setImageResource(R.drawable.thumb_p0);
        }else if (umurInt >= 1 && umurInt <= 3){
            gambar.setImageResource(R.drawable.thumb_p1);
        }else if (umurInt >= 4 && umurInt <= 5){
            gambar.setImageResource(R.drawable.thumb_p2);
        }else if (umurInt >= 6 && umurInt <= 8){
            gambar.setImageResource(R.drawable.thumb_p3);
        }else if (umurInt >= 9 && umurInt <= 11){
            gambar.setImageResource(R.drawable.thumb_p4);
        }else if (umurInt >= 12 && umurInt < 15){
            gambar.setImageResource(R.drawable.thumb_p5);
        }else if (umurInt >= 16 && umurInt < 30){
            gambar.setImageResource(R.drawable.thumb_p6);
        }else if (umurInt >= 30){
            gambar.setImageResource(R.drawable.thumb_p7);
        }
    }

    private void senData(int position, List<Tanaman> TanamanList){
        Intent sendData1 = new Intent(MainActivity.this, detail.class);
        sendData1.putExtra("Id_tanaman", TanamanList.get(position).getId());
        startActivity(sendData1);
    }

    public void btnLogout(View v){
        finish();
    }

    public void onBackPressed(){
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "Tekan lagi untuk keluar", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
