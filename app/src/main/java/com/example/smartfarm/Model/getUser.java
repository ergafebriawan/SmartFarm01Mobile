package com.example.smartfarm.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class getUser {
    @SerializedName("status")
    String status;
    @SerializedName("data")
    List<User> listDataUser;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<User> getListDataUser() {
        return listDataUser;
    }
    public void setListDataTanaman(List<User> listDataUser) {
        this.listDataUser = listDataUser;
    }
}
