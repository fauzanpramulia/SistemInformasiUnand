package com.fauzanpramulia.sisteminformasiunand.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    public SharedPreferences saveView;

    public Session(Context cntx) {
        saveView = PreferenceManager.getDefaultSharedPreferences(cntx);

    }

    public void setAngkatan(String angkatan) {
        saveView.edit().putString("angkatan", angkatan).commit();
    }

    public String getAngkatan() {
        String angkatan = saveView.getString("angkatan","");
        return angkatan;
    }

    public void setWarna(int warna) {
        saveView.edit().putInt("warna", warna).commit();
    }

    public int getWarna() {
        int warna = saveView.getInt("warna",0);
        return warna;
    }
    public void setNama(String nama) {
        saveView.edit().putString("nama", nama).commit();
    }

    public String getNama() {
        String nama = saveView.getString("nama","");
        return nama;
    }

    public void setBp(String bp) {
        saveView.edit().putString("bp", bp).commit();
    }

    public String getBp() {
        String bp = saveView.getString("bp","");
        return bp;
    }

    public void setDeskripsi(String des) {
        saveView.edit().putString("deskripsi", des).commit();
    }

    public String getDeskripsi() {
        String des = saveView.getString("deskripsi","");
        return des;
    }

    public void setDate(String date) {
        saveView.edit().putString("date", date).commit();
    }

    public String getDate() {
        String date = saveView.getString("date","");
        return date;
    }

}
