package com.example.smartfarm.Rest;

import com.example.smartfarm.Model.PushPutDelTanaman;
import com.example.smartfarm.Model.User;
import com.example.smartfarm.Model.getTanaman;
import com.example.smartfarm.Model.getUser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("Tanaman")
    Call<getTanaman> getTanaman();

    @GET("User")
    Call<ArrayList<User>> getUser(@Query("pin") int pin);

//    @FormUrlEncoded
//    @POST("Tanaman")
//    Call<PushPutDelTanaman> postTanaman(@Field("nama") String nama,
//                                       @Field("nomor") String nomor);
    @FormUrlEncoded
    @PUT("Tanaman")
    Call<PushPutDelTanaman> putTanaman(@Field("id_tanaman") String id,
                                       @Field("nama_tanaman") String nama,
                                       @Field("posisi") String nomor,
                                       @Field("gcode") String gcode,
                                       @Field("umur_tanaman") String umur,
                                       @Field("kadar_air") String kadar_air,
                                       @Field("suhu") String suhu,
                                       @Field("status") String status);

//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
//    Call<PushPutDelTanaman> deleteKontak(@Field("id") String id);
}
