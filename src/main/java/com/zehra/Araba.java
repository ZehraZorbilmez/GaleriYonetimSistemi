package com.zehra;

public class Araba {
    public String id;
    public String marka;
    public String model;
    public int yil;
    public int fiyat;

    public Araba(String marka, String id, String model, int yil, int fiyat) {
        this.marka = marka;
        this.id = id;
        this.model = model;
        this.yil = yil;
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "[ID:" + id + "] "
                + marka + ' '+ model + ',' +
                yil + ',' +
                fiyat + " TL"
                ;
    }
}
