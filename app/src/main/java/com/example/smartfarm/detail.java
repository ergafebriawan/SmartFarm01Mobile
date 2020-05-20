package com.example.smartfarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class detail extends AppCompatActivity {

    private Button btnTanam, btnPanen, btnCekAir, btnCekPH, btnSiram, btnPupuk, btnHapus, btnClose;
    private TextView namaTanaman, posisi, umur, kadarAir, kadarPH;
    private ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initComponents();
    }

    private void initComponents(){
        btnPanen = (Button)findViewById(R.id.btnPanen);
        btnTanam = (Button)findViewById(R.id.btnTananam);
        btnCekAir = (Button)findViewById(R.id.btnCekAir);
        btnCekPH = (Button)findViewById(R.id.btnCekPH);
        btnSiram = (Button)findViewById(R.id.btnSiram);
        btnPupuk = (Button)findViewById(R.id.btnPupuk);
        btnHapus = (Button)findViewById(R.id.btnHapus);
        btnClose = (Button)findViewById(R.id.btnClose);
        namaTanaman = (TextView) findViewById(R.id.namaTanaman);
        posisi = (TextView) findViewById(R.id.posisiTanaman);
        umur = (TextView) findViewById(R.id.umurTanaman);
        kadarAir = (TextView) findViewById(R.id.kadarAir);
        kadarPH = (TextView) findViewById(R.id.kadarPH);
        gambar = (ImageView)findViewById(R.id.gambarTanaman);
    }
}
