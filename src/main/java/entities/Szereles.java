package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Szereles implements SzerelesElkezdese, SzerelesBefejezese{
    private LocalDate SzerelesKezdete;
    private LocalDate SzerelesBefejezese;
    private Integer MunkavegzesKoltsege;
    private String Rendszam;
    private String Problema;
    //private String Jogositvanyszam;

    public Szereles(){}

    public Szereles(LocalDate szerelesKezdete, String rendszam) {
        SzerelesKezdete = szerelesKezdete;
        Rendszam = rendszam;
        //Jogositvanyszam = jogositvanyszam;
    }

    @Override
    public void setBefejezesIdeje(LocalDate BefejezesIdeje) {
        this.SzerelesBefejezese = BefejezesIdeje;
    }

    @Override
    public LocalDate getBefejezesIdeje() {
        return this.SzerelesBefejezese;
    }

    @Override
    public void setMunkavegzesKoltsege(Integer MunkavegzesKoltsege) {
        this.MunkavegzesKoltsege = MunkavegzesKoltsege;
    }


    @Override
    public Integer getMunkavegzesKoltsege() {
        return this.MunkavegzesKoltsege;
    }

    @Override
    public void setSzerelesMegkezdese(LocalDate szerelesMegkezdese) {
        this.SzerelesKezdete = szerelesMegkezdese;
    }

    @Override
    public LocalDate getSzerelesMegkezdese() {
        return this.SzerelesKezdete;
    }

    @Override
    public void setRendszam(String Rendszam) {
        this.Rendszam = Rendszam;
    }

    @Override
    public String getRendszam() {
        return this.Rendszam;
    }

    @Override
    public void setProblema(String problema) {
        this.Problema = problema;
    }

    @Override
    public String getProblema() {
        return this.Problema;
    }

    @Override
    public String toString() {
        return "Szereles{" +
                "SzerelesKezdete=" + SzerelesKezdete +
                ", SzerelesBefejezese=" + SzerelesBefejezese +
                ", MunkavegzesKoltsege=" + MunkavegzesKoltsege +
                ", Rendszam='" + Rendszam + '\'' +
                ", Problema='" + Problema + '\'' +
                '}';
    }
}
