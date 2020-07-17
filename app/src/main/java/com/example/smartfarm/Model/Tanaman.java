package com.example.smartfarm.Model;

import com.google.gson.annotations.SerializedName;

public class Tanaman {
    @SerializedName("id_tanaman")
    private String id_tanaman;
    @SerializedName("nama_tanaman")
    private String nama_tanaman;
    @SerializedName("posisi")
    private String posisi;
    @SerializedName("gcode")
    private String gcode;
    @SerializedName("umur_tanaman")
    private String umur_tanaman;
    @SerializedName("kadar_air")
    private String kadar_air;
    @SerializedName("suhu")
    private String suhu;
    @SerializedName("status")
    private String status;

    public Tanaman(String id_tanaman,
                   String nama_tanaman,
                   String posisi,
                   String gcode,
                   String umur_tanaman,
                   String kadar_air,
                   String suhu,
                   String status) {
        this.id_tanaman = id_tanaman;
        this.nama_tanaman = nama_tanaman;
        this.posisi = posisi;
        this.gcode = gcode;
        this.umur_tanaman = umur_tanaman;
        this.kadar_air = kadar_air;
        this.suhu = suhu;
        this.status = status;
    }

    public String getId() {
        return id_tanaman;
    }

    public void setId(String id) {
        this.id_tanaman = id;
    }

    public String getNama() {
        return nama_tanaman;
    }

    public void setNama(String nama) {
        this.nama_tanaman = nama;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode;
    }

    public String getUmur_tanaman() {
        return umur_tanaman;
    }

    public void setUmur_tanaman(String umur_tanaman) {
        this.umur_tanaman = umur_tanaman;
    }

    public String getKadar_air() {
        return kadar_air;
    }

    public void setKadar_air(String kadar_air) {
        this.kadar_air = kadar_air;
    }

    public String getSuhu() {
        return suhu;
    }

    public void setSuhu(String suhu) {
        this.suhu = suhu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
