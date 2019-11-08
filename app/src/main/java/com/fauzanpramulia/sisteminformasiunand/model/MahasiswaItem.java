package com.fauzanpramulia.sisteminformasiunand.model;

import java.io.Serializable;

public class MahasiswaItem implements Serializable{
    public String no, nama, bp, fakultas,foto, jk;

    public MahasiswaItem(String no, String nama, String bp, String fakultas, String foto, String jk) {
        this.no = no;
        this.nama = nama;
        this.bp = bp;
        this.fakultas = fakultas;
        this.foto = foto;
        this.jk = jk;
    }

    public MahasiswaItem() {
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setName(String name) {
        this.nama = name;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return nama;
    }

    public String getBp() {
        return bp;
    }

    public String getFakultas(){
        return fakultas;
    }

    public String getFoto() {
        return foto;
    }

    public String getJk() {
        return jk;
    }
}
