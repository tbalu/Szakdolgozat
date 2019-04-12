package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Szereles implements SzerelesElkezdese, SzerelesBefejezese{
    private LocalDate SzerelesKezdete;
    private LocalDate SzerelesBefejezese;
    private Integer MunkavegzesKoltsege;
    private String Rendszam;
    private String Jogositvanyszam;

    public Szereles(){}
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
    public void setJogositvanyszam(String Jogositvanyszam) {

    }

    @Override
    public String getJogositvanyszam() {
        return this.Jogositvanyszam;
    }
}
