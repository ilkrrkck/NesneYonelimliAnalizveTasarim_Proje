package SogutucuKontrolCihazi;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private double sicaklik;

    private SicaklikAlgilayici() {
        sicaklik = (Math.random() * 10) + 28; //18~28
    }

    @Override
    public void sicaklikAta(boolean sogutucuAcikMi) {
        if (sogutucuAcikMi) //true ise
        {
            this.sicaklik = (Math.random() * 8) + 10; //10~18
        } else {
            this.sicaklik = (Math.random() * 10) + 25; //25~35
        }
    }

    @Override
    public double sicaklikOku() {
        return this.sicaklik;
    }

    public static class SicaklikAlgilayiciBuilder {
        private double sicaklik;

        public SicaklikAlgilayici build() {
            return new SicaklikAlgilayici();
        }
    }
}

