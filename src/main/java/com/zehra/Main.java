package com.zehra;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        Scanner input = new Scanner(System.in);
        Araba a1 = new Araba("Toyota","1","Corolla",2020,500000);
        Araba a2 = new Araba("Renault","2","Clio",2018,350000);
        Araba a3 = new Araba("BMW","3","3.20i",2021,950000);
        Araba a4 = new Araba("Mercedes","4","C200",2019,890000);
        Araba a5 = new Araba("Toyota","5","Yaris",2017,320000);
        Araba a6 = new Araba("Renault","6","Megan",2020,480000);
        ArrayList<Araba> arabalar = new ArrayList<>();
        arabalar.add(a1);
        arabalar.add(a2);
        arabalar.add(a3);
        arabalar.add(a4);
        arabalar.add(a5);
        arabalar.add(a6);

        ArrayList<Satis> satislar = new ArrayList<>();

        String secim;
        boolean calisiyor = true;
        while (calisiyor) {
            System.out.println("----Galeri Yönetim Sistemi----");
            System.out.println("1-Tüm Arabaları Listele");
            System.out.println("2-Fiyata Göre Filtrele");
            System.out.println("3-Markaya Göre Ara");
            System.out.println("4-Araba Satın Al");
            System.out.println("5-Satışları Görüntüle");
            System.out.println("6-Çıkış");
            System.out.print("Seçiminizi giriniz:");
            secim = input.nextLine();
            switch (secim) {
                case "1":
                    app.listele(arabalar);
                    break;
                case "2":
                    System.out.print("Filtrelemek istediğiniz max fiyatı giriniz:");
                    int filtrele = input.nextInt();
                    input.nextLine();
                    app.filtrele(arabalar,filtrele);
                    break;
                case "3":
                    String marka;
                    System.out.print("Listelemek istediğiniz araba markasını giriniz:");
                    marka= input.nextLine();
                    app.markayaGoreArama(arabalar,marka);
                    break;
                case "4":
                    System.out.print("Satın almak istediğiniz araba ID:");
                    String id= input.nextLine();
                    Musteri musteri = new Musteri();
                    System.out.print("Müşteri Adı:");
                    musteri.ad = input.nextLine();
                    System.out.print("Müşteri Soyadı:");
                    musteri.soyad= input.nextLine();
                    app.satinAl(arabalar,id,musteri,satislar);
                    break;
                case "5":
                    for(Satis satis:satislar){
                        System.out.println(satis);
                    }
                    break;
                case "6":
                    calisiyor = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim yaptınız");

            }


        }


    }
    public  void listele(ArrayList<Araba> arabalar){
        System.out.println("--Mevcut Arabalar--");
        for(Araba araba:arabalar){
            System.out.println(araba);
        }
        //arabalar.forEach(System.out::println);
    }
    public  void markayaGoreArama(ArrayList<Araba> arabalar,String marka){
        boolean varMi = false;
        for(Araba araba:arabalar){
            if(araba.marka.toLowerCase().contains(marka.toLowerCase()) ){
                varMi = true;
                System.out.println(araba);
            }

        }
        if(varMi == false){
            System.out.println(marka + " markasına ait araç bulunmamaktadır");
        }

    }
    public  void filtrele(ArrayList<Araba> arabalar,int fiyat){
        boolean varMi = false;
        for(Araba araba :arabalar){
            if(araba.fiyat < fiyat){
                varMi = true;
                System.out.println(araba);
            }
        }
        if(varMi == false){
            System.out.println("Bu fiyata uygun araç yok");
        }
    }
    public  void satinAl(ArrayList<Araba> arabalar,String id,Musteri musteri,ArrayList<Satis> satislar){
        Araba silinecek = null;
        for (Araba araba : arabalar) {
            if (araba.id.equals(id)) {
                silinecek = araba;
                break;
            }
        }
        if (silinecek != null) {
            Satis satis = new Satis(musteri,silinecek);
            satislar.add(satis);
            arabalar.remove(silinecek);
            System.out.println("Satış Gerçekleşti");
        } else {
            System.out.println("Belirtilen ID'ye sahip araba bulunamadı.");
        }

    }


}