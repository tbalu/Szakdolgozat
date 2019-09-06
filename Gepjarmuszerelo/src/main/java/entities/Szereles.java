package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
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

    @ManyToOne
    @JoinColumn(name = "gepjarmu_id")
    private Gepjarmu gepjarmu;

    @OneToOne
    @JoinColumn(name = "tulajdonos_id")
    private Tulajdonos tulajdonos;

    @Column(name = "munkavegzes_koltsege")
    private Integer munkavegzesKoltsege;

    @Column(name = "munkaorak_szama")
    private Integer munkaorakSzama;

    public Szereles(Timestamp szerelesKezdete, Timestamp szerelesVege, Gepjarmu gepjarmu, Tulajdonos tulajdonos,
                    Integer munkavegzesKoltsege, Integer munkaorakSzama) {
        this.szerelesKezdete = szerelesKezdete;
        this.szerelesVege = szerelesVege;
        this.gepjarmu = gepjarmu;
        this.tulajdonos = tulajdonos;
        this.munkavegzesKoltsege = munkavegzesKoltsege;
        this.munkaorakSzama = munkaorakSzama;
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
}