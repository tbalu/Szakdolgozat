package entities;

public class Gepjarmu {
    private String Marka;
    private String Rendszam;

    public Gepjarmu(String marka, String rendszam) {
        Marka = marka;
        Rendszam = rendszam;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public String getRendszam() {
        return Rendszam;
    }

    public void setRendszam(String rendszam) {
        Rendszam = rendszam;
    }
}
