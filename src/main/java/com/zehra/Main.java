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


    }
}