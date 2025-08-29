package com.zehra;

import java.util.List;

public class Araba {
    private static int sayac=1;
    public int id;
    public String baslik;
    public List<String> resimUrl;
    public String marka;
    public String model;
    public String kilometre;
    public String vitesTipi;
    public String yakitTipi;
    public int yil;
    public int fiyat;

    public Araba(List<String> resimUrl,String baslik,String marka, String model, String kilometre, int yil, int fiyat,String vitesTipi,String yakitTipi) {
        this.id = sayac++;
        this.baslik = baslik;
        this.resimUrl = resimUrl;
        this.marka = marka;
        this.model = model;
        this.kilometre = kilometre;
        this.vitesTipi = vitesTipi;
        this.yakitTipi = yakitTipi;
        this.yil = yil;
        this.fiyat = fiyat;
    }


    @Override
    public String toString() {
        return baslik + "\n" +"[ID:" + id + "] "
                + marka + ' '+ model + ',' +
                yil + ',' + kilometre + "km ,"+ vitesTipi +
                "," + yakitTipi + "," + fiyat + " TL" +
                "\n" +String.join("\n", resimUrl)+ "\n"
                ;
    }
}
