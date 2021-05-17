package SogutucuKontrolCihazi;

import java.sql.*;
import java.util.Scanner;

public class AgArayuzu implements IObserver {
    private boolean cihazDurum;
    MerkezIslem merkezIslem = new MerkezIslem();

    public AgArayuzu() throws SQLException {

        System.out.println("\nAkıllı cihaz çalıştırıldı");
        System.out.println("------------------------------------------------------------");
        VeritabaniPostgreSQL.KullaniciGiris(); //abstract
        //MerkezIslem merkezIslem=new MerkezIslem();
        islem(); //işlemler burada seçiliyor ve işleniyor
    }


    @Override
    public void beklemede() {

        System.out.println("\nCihaz işlem bekliyor...");
        System.out.println("------------------------------------------------------------");
        cihazDurum = false;
    }

    @Override
    public void kontrol() {

        System.out.println("\nCihaz kontrol ediliyor...");
        System.out.println("------------------------------------------------------------");
        cihazDurum = true;
    }

    @Override
    public void islem() {

        Scanner islemSecim = new Scanner(System.in);

        while (true) {
            System.out.println("Lütfen İşlem seçiniz");
            System.out.println("1-Soğutucu Aç");
            System.out.println("2-Soğutucu Kapat");
            System.out.println("3-Sıcaklık Görüntüle");
            System.out.println("4-Çıkış Yap");
            System.out.print("İşleminiz: ");
            int secim = islemSecim.nextInt();
            switch (secim) {
                case 1:
                    kontrol();
                    merkezIslem.sogutucuAcik(this);
                    beklemede();
                    break;
                case 2:
                    kontrol();
                    merkezIslem.sogutucuKapali(this);
                    beklemede();
                    break;
                case 3:
                    kontrol();
                    merkezIslem.sicaklikGoster(this);
                    beklemede();
                    break;
                case 4:

                    System.out.println("\nAkıllı cihaz kapanıyor...");
                    System.exit(0);
                    break;
                default:

                    System.out.println("\nListelenen aksiyonlardan birini seçiniz!");
                    System.out.println("------------------------------------------------------------");
            }
        }

    }


}
