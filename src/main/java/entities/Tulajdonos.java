package entities;

public class Tulajdonos {
    private String Nev;
    private String Jogositvanyszam;
    private String Lakcim;

    public Tulajdonos(String nev, String jogositvanyszam, String lakcim) {
        Nev = nev;
        Jogositvanyszam = jogositvanyszam;
        Lakcim = lakcim;
    }

    public String getNev() {
        return Nev;
    }

    public void setNev(String nev) {
        Nev = nev;
    }

    public String getJogositvanyszam() {
        return Jogositvanyszam;
    }

    public void setJogositvanyszam(String jogositvanyszam) {
        Jogositvanyszam = jogositvanyszam;
    }

    public String getLakcim() {
        return Lakcim;
    }

    public void setLakcim(String lakcim) {
        Lakcim = lakcim;
    }
}
