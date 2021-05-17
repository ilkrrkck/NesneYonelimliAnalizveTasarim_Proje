package SogutucuKontrolCihazi;

import java.sql.SQLException;

public class MerkezIslem implements IObservableMerkezIslem {
    private boolean sogutucuDurum;

    /* Dependency Inversion */
    IEyleyici islem = new Eyleyici.EyleyiciBuilder()
            .build(); //builder kullanımı

    ISicaklikAlgilayici sicaklikAlgila = new SicaklikAlgilayici.SicaklikAlgilayiciBuilder()
            .build(); //builder kullanımı

    public void sistemiBaslat() throws SQLException {
        new AgArayuzu();
    }


    @Override
    public void sogutucuAcik(IObserver observer) {
        if (this.sogutucuDurum) //true ise
        {

            System.out.println("\n*** Soğutucu zaten açık ! ***");

        } else {
            this.sogutucuDurum = islem.sogutucuAc();
            sicaklikAlgila.sicaklikAta(sogutucuDurum);

            System.out.println("\n*** Soğutucu Açıldı ! ***");

        }
    }

    @Override
    public void sogutucuKapali(IObserver observer) {
        if (!this.sogutucuDurum) //false ise
        {

            System.out.println("\n*** Soğutucu zaten kapalı !***");

        } else {
            this.sogutucuDurum = islem.sogutucuKapat();
            sicaklikAlgila.sicaklikAta(sogutucuDurum);

            System.out.println("\n*** Soğutucu Kapalı! ***");

        }
    }

    @Override
    public void sicaklikGoster(IObserver observer) {

        System.out.println("\nSıcaklık Değeri: " + sicaklikAlgila.sicaklikOku());

    }
}