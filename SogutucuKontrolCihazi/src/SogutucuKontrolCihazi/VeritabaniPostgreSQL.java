package SogutucuKontrolCihazi;

import java.sql.*;
import java.util.Scanner;

public abstract class VeritabaniPostgreSQL {
    static boolean dogrulama = false;

    //Connection nesnesinden baglan fonksiyonu:
    private static Connection baglan() {
        Connection baglanti = null;
        try {
            baglanti = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SogutucuKontrolCihazi",
                    "postgres", "159753");
            if (baglanti != null) //bağlantı varsa
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baglanti;
    }

    public static void KullaniciGiris() throws SQLException {
        Connection dogrulamaBaglantisi = baglan();
        String vtKullaniciAdi = null, vtSifre = null, vtIsim;
        Statement stmt = dogrulamaBaglantisi.createStatement();
        String sorgu = "SELECT *  FROM \"kullanici\"";
        while (dogrulama == false) {
            ResultSet rs = stmt.executeQuery(sorgu);
            Scanner veriCek = new Scanner(System.in);
            System.out.print("Kullanıcı adı: ");
            String kAdi = veriCek.next();
            System.out.print("Şifrenizi gir: ");
            String sifre = veriCek.next();
            System.out.println("\n");
            // Kullanıcı adı ve şifre kontrolü
            while (rs.next()) {
                vtKullaniciAdi = rs.getString("kullaniciadi");
                vtSifre = rs.getString("kullanicisifre");
                vtIsim = rs.getString("isim");
                if (kAdi.equals(vtKullaniciAdi) && sifre.equals(vtSifre)) {
                    System.out.println(String.format("Giriş başarılı!\nHoş geldin %s\n", vtIsim));
                    dogrulama = true;
                    break;
                } else {
                    System.out.println("Kullanıcı adı ve şifre kombinasyonu yanlış!\nKullanıcı bilgilerinizi lütfen tekrar giriniz.\n");
                    dogrulama = false;
                    break;
                }
            }
        }
        dogrulamaBaglantisi.close();
    }
}