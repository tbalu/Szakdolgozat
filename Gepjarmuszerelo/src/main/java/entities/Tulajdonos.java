package entities;

import org.pmw.tinylog.Logger;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tulajdonos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name = "telefonszam")
    private String telefonszam;

    @Column(name = "nev")
    private String nev;

    @Column(name = "lakcim")
    private String lakcim;
/*
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tulajdonos")
    private List<Gepjarmu> Gepjarmuvek = new ArrayList<>();*/
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "tulajdonos", fetch = FetchType.LAZY)
    private List<Gepjarmu> Gepjarmuvek = new ArrayList<>();

    @Override
    public String toString() {
        return "Tulajdonos{" +
                "nev='" + nev + '\'' +
                ", lakcim='" + lakcim + '\'' +
                ", telefonszam='" + telefonszam + '\'' +
                '}';
    }

    public Tulajdonos(String nev, String lakcim, String telefonszam) {
        this.nev = nev;
        this.lakcim = lakcim;
        this.telefonszam = telefonszam;

    }

    public Tulajdonos(String telefonszam, String nev, String lakcim, List<Gepjarmu> gepjarmuvek) {
        this.telefonszam = telefonszam;
        this.nev = nev;
        this.lakcim = lakcim;
        Gepjarmuvek = gepjarmuvek;
    }
    public Tulajdonos(){
        Logger.info("Noarg Tu!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public List<Gepjarmu> getGepjarmuvek() {
        return Gepjarmuvek;
    }

    public void setGepjarmuvek(List<Gepjarmu> gepjarmuvek) {
        Gepjarmuvek = gepjarmuvek;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    public String getLakcim() {
        return lakcim;
    }

    public void setLakcim(String lakcim) {
        this.lakcim = lakcim;
    }
}
