package com.zehra;


import java.util.ArrayList;
import java.util.Scanner;
import org.jsoup.*;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        Scanner input = new Scanner(System.in) ;

        ArrayList<Araba> arabalar = new ArrayList<>();
        AracVeriCekici aracVeriCekici = new AracVeriCekici();
        ArrayList<Satis> satislar = new ArrayList<>();

        try{
            arabalar=aracVeriCekici.vericek();
        }catch (Exception e){
            e.printStackTrace();
        }

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
                    int filtrele = Integer.parseInt(input.nextLine());
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
                    int id= Integer.parseInt(input.nextLine());
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
    public  void satinAl(ArrayList<Araba> arabalar,int id,Musteri musteri,ArrayList<Satis> satislar){
        Araba silinecek = null;
        for (Araba araba : arabalar) {
            if (araba.id == id) {
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