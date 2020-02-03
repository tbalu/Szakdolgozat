package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import entities.*;
import org.pmw.tinylog.Logger;

import javax.persistence.*;


@Entity
public class Szereles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "szereles_kezdete")
    private Timestamp szerelesKezdete;

    @Column(name = "szereles_vege")
    private Timestamp szerelesVege;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gepjarmu_id")
    private Gepjarmu gepjarmu;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tulajdonos_id")
    private Tulajdonos tulajdonos;

    @Column(name = "munkavegzes_koltsege")
    private Integer munkavegzesKoltsege;

    /*
    @Column(name = "munkaorak_szama")
    private Integer munkaorakSzama;*/
/*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "szereles", fetch = FetchType.LAZY)
    private List<Alkatresz> alkatreszek;
*/
    //private List<GarancialisAlkatresz> garancialisAlkatreszek;

    //private List<GarancialisJavitas> garancialisJavitasok;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "szereles", fetch = FetchType.LAZY)
    private List<Alkatresz> alkatreszek;

   // private List<OsJavitas> javitasok;


    public Szereles(){}

    public Szereles(Timestamp szerelesKezdete, Timestamp szerelesVege, Gepjarmu gepjarmu, Tulajdonos tulajdonos,
                    Integer munkavegzesKoltsege, Integer munkaorakSzama, List<Alkatresz> alkatreszek) {
        this.szerelesKezdete = szerelesKezdete;
        this.szerelesVege = szerelesVege;
        this.gepjarmu = gepjarmu;
        this.tulajdonos = tulajdonos;
        this.munkavegzesKoltsege = munkavegzesKoltsege;
        //this.munkaorakSzama = munkaorakSzama;
        this.alkatreszek = alkatreszek;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getSzerelesKezdete() {
        return szerelesKezdete;
    }

    public void setSzerelesKezdete(Timestamp szerelesKezdete) {
        this.szerelesKezdete = szerelesKezdete;
    }

    public Timestamp getSzerelesVege() {
        return szerelesVege;
    }

    public void setSzerelesVege(Timestamp szerelesVege) {
        this.szerelesVege = szerelesVege;
    }

    public Gepjarmu getGepjarmu() {
        return gepjarmu;
    }

    public void setGepjarmu(Gepjarmu gepjarmu) {
        this.gepjarmu = gepjarmu;
    }

    public Tulajdonos getTulajdonos() {
        return tulajdonos;
    }

    public void setTulajdonos(Tulajdonos tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public Integer getMunkavegzesKoltsege() {
        return munkavegzesKoltsege;
    }

    public void setMunkavegzesKoltsege(Integer munkavegzesKoltsege) {
        this.munkavegzesKoltsege = munkavegzesKoltsege;
    }

    /*
    public Integer getMunkaorakSzama() {
        return munkaorakSzama;
    }

    public void setMunkaorakSzama(Integer munkaorakSzama) {
        this.munkaorakSzama = munkaorakSzama;
    }*/

    public List<Alkatresz> getAlkatreszek() {
        return alkatreszek;
    }

    public void setAlkatreszek(List<Alkatresz> alkatreszek) {
        this.alkatreszek = alkatreszek;
    }

    @Override
    public String toString() {
        return "Szereles{" +
                "id=" + id +
                ", szerelesKezdete=" + szerelesKezdete +
                ", szerelesVege=" + szerelesVege +
                ", gepjarmu=" + gepjarmu +
                ", tulajdonos=" + tulajdonos +
                ", munkavegzesKoltsege=" + munkavegzesKoltsege +
               // ", munkaorakSzama=" + munkaorakSzama +
                ", alkatreszek=" + alkatreszek +
                '}';
    }
}
