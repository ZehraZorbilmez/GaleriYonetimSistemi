package com.zehra;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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

        int secim;
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
            secim = input.nextInt();
            switch (secim) {
                case 1:
                    listele(arabalar);
                    break;
                case 2:
                    System.out.print("Filtrelemek istediğiniz max fiyatı giriniz:");
                    int filtrele = input.nextInt();
                    filtrele(arabalar,filtrele);
                    break;
                case 3:
                    String marka;
                    System.out.println("Listelemek istediğiniz araba markasını giriniz:");
                    input.nextLine();
                    marka= input.nextLine();
                    markayaGoreArama(arabalar,marka);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    calisiyor = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim yaptınız");

            }


        }


    }
    public static void listele(ArrayList<Araba> arabalar){
        System.out.println("--Mevcut Arabalar--");
        for(Araba araba:arabalar){
            System.out.println(araba);
        }
        //arabalar.forEach(System.out::println);
    }
    public static void markayaGoreArama(ArrayList<Araba> arabalar,String marka){
        for(Araba araba:arabalar){
            if(araba.marka.equalsIgnoreCase(marka)){
                System.out.println(araba);
            }

        }
    }
    public static void filtrele(ArrayList<Araba> arabalar,int fiyat){
        for(Araba araba :arabalar){
            if(araba.fiyat < fiyat){
                System.out.println(araba);
            }
        }
    }


}