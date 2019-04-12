package entities;

public class Tulajdonos {
    private String Nev;

    private String Lakcim;
    private String Jogositvanyszam;

    @Override
    public String toString() {
        return "Tulajdonos{" +
                "Nev='" + Nev + '\'' +
                ", Lakcim='" + Lakcim + '\'' +
                ", Jogositvanyszam='" + Jogositvanyszam + '\'' +
                '}';
    }

    public Tulajdonos(String nev, String lakcim, String jogositvanyszam) {
        Nev = nev;
        Lakcim = lakcim;
        Jogositvanyszam = jogositvanyszam;
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
