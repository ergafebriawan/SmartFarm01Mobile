package com.example.smartfarm.Model;

import com.google.gson.annotations.SerializedName;

public class PushPutDelTanaman {
    @SerializedName("status")
    String status;
    @SerializedName("data")
    Tanaman mTanaman;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Tanaman getmTanaman() {
        return mTanaman;
    }
    public void setmTanaman(Tanaman tanaman) {
        mTanaman = tanaman;
    }
}
