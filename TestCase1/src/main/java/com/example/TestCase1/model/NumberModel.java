package com.example.TestCase1.model;


public class NumberModel {
    private int angka;
    private String terbilang;

    public NumberModel(int angka, String terbilang) {
        this.angka = angka;
        this.terbilang = terbilang;
    }

    public int getAngka() { return angka; }
    public void setAngka(int angka) { this.angka = angka; }

    public String getTerbilang() { return terbilang; }
    public void setTerbilang(String terbilang) { this.terbilang = terbilang; }
}
 