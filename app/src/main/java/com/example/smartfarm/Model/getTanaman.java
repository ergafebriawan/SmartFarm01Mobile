package com.example.smartfarm.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class getTanaman {
    @SerializedName("status")
    String status;
    @SerializedName("data")
    List<Tanaman> listDataTanaman;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<Tanaman> getListDataTanaman() {
        return listDataTanaman;
    }
    public void setListDataTanaman(List<Tanaman> listDataTanaman) {
        this.listDataTanaman = listDataTanaman;
    }
}
