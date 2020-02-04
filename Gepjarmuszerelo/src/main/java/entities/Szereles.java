package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "ugyfel_id")
    private Ugyfel ugyfel;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "szereles", fetch = FetchType.LAZY)
    private List<OsJavitas> javitasok = new ArrayList<>();


    @Column(name = "munkavegzes_koltsege")
    private Integer munkavegzesKoltsege;


    public Szereles(){}

    public Szereles(Timestamp szerelesKezdete, Timestamp szerelesVege, Gepjarmu gepjarmu, Ugyfel ugyfel, List<OsJavitas> javitasok, Integer munkavegzesKoltsege) {
        this.szerelesKezdete = szerelesKezdete;
        this.szerelesVege = szerelesVege;
        this.gepjarmu = gepjarmu;
        this.ugyfel = ugyfel;
        this.javitasok = javitasok;
        this.munkavegzesKoltsege = munkavegzesKoltsege;
    }

    public Szereles(Timestamp szerelesKezdete, Timestamp szerelesVege, Gepjarmu gepjarmu, Ugyfel ugyfel,
                    Integer munkavegzesKoltsege) {
        this.szerelesKezdete = szerelesKezdete;
        this.szerelesVege = szerelesVege;
        this.gepjarmu = gepjarmu;
        this.ugyfel = ugyfel;
        this.munkavegzesKoltsege = munkavegzesKoltsege;
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

    public Ugyfel getUgyfel() {
        return ugyfel;
    }

    public void setUgyfel(Ugyfel ugyfel) {
        this.ugyfel = ugyfel;
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



    @Override
    public String toString() {
        return "Szereles{" +
                "id=" + id +
                ", szerelesKezdete=" + szerelesKezdete +
                ", szerelesVege=" + szerelesVege +
                ", gepjarmu=" + gepjarmu +
                ", ugyfel=" + ugyfel +
                ", munkavegzesKoltsege=" + munkavegzesKoltsege +
               // ", munkaorakSzama=" + munkaorakSzama +
               // ", alkatreszek=" + alkatreszek +
                '}';
    }
}
