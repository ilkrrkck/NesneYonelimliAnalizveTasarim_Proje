package SogutucuKontrolCihazi;

public class Eyleyici implements IEyleyici {
    private boolean sogutucuDurumu;

    private Eyleyici(EyleyiciBuilder builder) {

    }

    @Override
    public boolean sogutucuAc() {
        this.sogutucuDurumu = true;
        return sogutucuDurumu;
    }

    @Override
    public boolean sogutucuKapat() {
        this.sogutucuDurumu = false;
        return sogutucuDurumu;
    }

    public static class EyleyiciBuilder {

        public Eyleyici build() {
            return new Eyleyici(this);
        }
    }
}