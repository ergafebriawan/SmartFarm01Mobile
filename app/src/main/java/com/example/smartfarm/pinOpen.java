package com.example.smartfarm;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartfarm.Model.User;
import com.example.smartfarm.Model.getUser;
import com.example.smartfarm.Rest.ApiClient;
import com.example.smartfarm.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class pinOpen extends AppCompatActivity {

    private EditText inPin;
    private ImageView btnCancel, btnLogin;
    //private ImageView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private String id, username, pin, log;
    private String password= "12345";

    ApiInterface lApiinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_open);
        inPin = (EditText) findViewById(R.id.inPin);
        btnCancel = (ImageView)findViewById(R.id.btnCancel);
        btnLogin = (ImageView)findViewById(R.id.btnLogin);
        lApiinterface = ApiClient.getClient().create(ApiInterface.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inPin.getText().toString().length()==0){
                    Toast.makeText(pinOpen.this, "Isikan password dulu!", Toast.LENGTH_SHORT).show();
                }else {
                    if(inPin.getText().toString().equals(password)){
                        Intent masuk= new Intent(pinOpen.this, MainActivity.class);
                        startActivity(masuk);
                        Toast.makeText(pinOpen.this, "Open", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(pinOpen.this, "Password salah!", Toast.LENGTH_SHORT).show();
                        inPin.setText("");
                    }
                }
//                Call<ArrayList<User>> result = lApiinterface.getUser(12345);
//                result.enqueue(new Callback<ArrayList<User>>() {
//                    @Override
//                    public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
//                        ArrayList<User> ListUser = response.body();
//                        Toast.makeText(pinOpen.this, ListUser.toString(), Toast.LENGTH_LONG).show();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ArrayList<User>> call, Throwable t) {
//                        Toast.makeText(pinOpen.this, "Tidak Terhubung ke server", Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

//    private void initKeyboard(){
//        btn0 = (ImageView)findViewById(R.id.btn0);
//        btn1 = (ImageView)findViewById(R.id.btn1);
//        btn2 = (ImageView)findViewById(R.id.btn2);
//        btn3 = (ImageView)findViewById(R.id.btn3);
//        btn4 = (ImageView)findViewById(R.id.btn4);
//        btn5 = (ImageView)findViewById(R.id.btn5);
//        btn6 = (ImageView)findViewById(R.id.btn6);
//        btn7 = (ImageView)findViewById(R.id.btn7);
//        btn8 = (ImageView)findViewById(R.id.btn8);
//        btn9 = (ImageView)findViewById(R.id.btn9);
//
//        btn0.setOnClickListener((View.OnClickListener) this);
//        btn1.setOnClickListener((View.OnClickListener) this);
//        btn2.setOnClickListener((View.OnClickListener) this);
//        btn3.setOnClickListener((View.OnClickListener) this);
//        btn4.setOnClickListener((View.OnClickListener) this);
//        btn5.setOnClickListener((View.OnClickListener) this);
//        btn6.setOnClickListener((View.OnClickListener) this);
//        btn7.setOnClickListener((View.OnClickListener) this);
//        btn8.setOnClickListener((View.OnClickListener) this);
//        btn9.setOnClickListener((View.OnClickListener) this);
//    }
//
//    public void  OnClick(View view){
//        switch (view.getId()){
//            case R.id.btn0:
//
//                break;
//        }
//    }
}
