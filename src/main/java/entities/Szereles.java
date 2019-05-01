package entities;

import java.io.Serializable;
import java.time.LocalDate;
import entities.*;

import javax.persistence.*;


@Entity
@Table(name = "szereles")
public class Szereles  implements SzerelesElkezdese, SzerelesBefejezese, Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rendszam")
    private Gepjarmu gepjarmu;

    @Id
    @Column(nullable = false, name = "szereles_kezdete")
    private LocalDate SzerelesKezdete;

    @Column(name = "szereles_befejezese")
    private LocalDate SzerelesBefejezese;

    @Column(name = "munkaveges_koltsege")
    private Integer MunkavegzesKoltsege;

   // private String Problema;
    //private String Jogositvanyszam;

    public Szereles(){}

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  /*  public Szereles(String rendszam,LocalDate szerelesKezdete ) {
        SzerelesKezdete = szerelesKezdete;
        Rendszam = rendszam;
        //Jogositvanyszam = jogositvanyszam;
    }
    public Szereles(String rendszam){
        this.Rendszam = rendszam;
        this.SzerelesKezdete = LocalDate.now();
    }
*/
    public Szereles(Gepjarmu gepjarmu, LocalDate szerelesKezdete, LocalDate szerelesBefejezese, Integer munkavegzesKoltsege) {
        gepjarmu = gepjarmu;
        SzerelesKezdete = szerelesKezdete;
        SzerelesBefejezese = szerelesBefejezese;
        MunkavegzesKoltsege = munkavegzesKoltsege;

    }

    @Override
    public void setSzerelesBefejezese(LocalDate BefejezesIdeje) {
        this.SzerelesBefejezese = BefejezesIdeje;
    }

    @Override
    public LocalDate getSzerelesBefejezese() {
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
    public void setSzerelesKezdete(LocalDate szerelesMegkezdese) {
        this.SzerelesKezdete = szerelesMegkezdese;
    }

    @Override
    public LocalDate getSzerelesKezdete() {
        return this.SzerelesKezdete;
    }

    @Override
    public void setGepjarmu(Gepjarmu gepjarmu) {
        this.gepjarmu = gepjarmu;
    }

    @Override
    public Gepjarmu getGepjarmu() {
        return this.gepjarmu;
    }


    @Override
    public String toString() {
        return "Szereles{" +
                "SzerelesKezdete=" + SzerelesKezdete +
                ", SzerelesBefejezese=" + SzerelesBefejezese +
                ", MunkavegzesKoltsege=" + MunkavegzesKoltsege +
                ", Rendszam='" + gepjarmu.getRendszam() + '\'' +

                '}';
    }
}
