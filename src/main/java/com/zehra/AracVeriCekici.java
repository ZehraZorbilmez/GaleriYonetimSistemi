package com.zehra;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;


public class AracVeriCekici {


    public ArrayList<Araba> vericek() throws IOException {

       String marka="",model="",km="",vitesTipi="",yakitTipi="",resimUrl="";
       int yil=0,fiyat;
       ArrayList<Araba> arabalar = new ArrayList<>();

       try {
            for(int j=1 ; j<=20 ;j++) {

                String url = "https://www.arabam.com/ikinci-el?page=" + j;
                Document doc = Jsoup.connect(url).
                        userAgent("Mozilla/5.0...")
                        .get();

                Elements basliklar = doc.select("h4.crop-after.crop-after-40.odd-ca40");
                Elements detaySayfa = doc.select("a.smallest-text-minus.ovh");
                Elements images = doc.select("a.smallest-text-minus.ovh img.listing-image");

                if(basliklar.isEmpty() || detaySayfa.isEmpty() || images.isEmpty()){
                    System.out.println("Sayfa" + j + ":Elementler bulunamadı , atlanıyor");
                    continue;
                }

                for (int i = 0; i < basliklar.size(); i++) {

                    String baslik = basliklar.get(i).text();
                    String detayUrl = "https://www.arabam.com" + detaySayfa.get(i).attr("href");
                    resimUrl = images.get(i).attr("data-src");

                    Document detayDoc = Jsoup.connect(detayUrl).
                            userAgent("Mozilla/5.0...")
                            .get();

                    String fiyatStr = detayDoc.select("div.product-price div.desktop-information-price").text().trim();
                    fiyatStr = fiyatStr.replace("TL", "").replace(".", "").trim();
                    fiyat = Integer.parseInt(fiyatStr);

                    Elements ozellikler = detayDoc.select("div.property-item");

                    for (Element ozellik : ozellikler) {
                        String key = ozellik.select("div.property-key").text().trim();
                        String value = ozellik.select("div.property-value").text().trim();

                        if (key.equals("Marka")) {
                            marka = value;
                        } else if (key.equals("Model")) {
                            model = value;
                        } else if (key.equals("Yıl")) {
                            yil = Integer.parseInt(value);
                        } else if (key.equals("Kilometre")) {
                            km = value.replace(".", "").replace("km", "").trim();
                        } else if (key.equals("Vites Tipi")) {
                            vitesTipi = value;
                        } else if (key.equals("Yakıt Tipi")) {
                            yakitTipi = value;
                        }
                    }
                    arabalar.add(new Araba(resimUrl, baslik, marka, model, km, yil, fiyat, vitesTipi, yakitTipi));
                    Thread.sleep(500);
                }
                Thread.sleep(500);

            }


       } catch (Exception e) {
           System.err.println("Genel hata: " + e.getMessage());
           e.printStackTrace();
       }
       return arabalar;



   }
}
