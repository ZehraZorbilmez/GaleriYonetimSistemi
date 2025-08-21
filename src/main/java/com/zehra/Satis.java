package com.zehra;

public class Satis {
    Musteri musteri;
    Araba araba;

    public Satis(Musteri musteri, Araba araba) {
        this.musteri = musteri;
        this.araba = araba;
    }

    @Override
    public String toString() {
        return
                musteri.ad + ' '+
                        musteri.soyad +"=> " + araba.marka + ' '+ araba.model + ',' +
                        araba.yil + ',' +
                        araba.fiyat + " TL";
    }

}
