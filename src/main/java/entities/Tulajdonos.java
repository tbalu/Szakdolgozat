package entities;

import org.pmw.tinylog.Logger;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Tulajdonos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "jogositvanyszam")
    private String Jogositvanyszam;

    @Column(name = "nev")
    private String Nev;

    @Column(name = "lakcim")
    private String Lakcim;
/*
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tulajdonos")
    private List<Gepjarmu> Gepjarmuvek = new ArrayList<>();*/
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tulajdonos")
    @ElementCollection
    private Set<Gepjarmu> Gepjarmuvek = new HashSet<>();

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

    public Tulajdonos(String jogositvanyszam, String nev, String lakcim, Set<Gepjarmu> gepjarmuvek) {
        Jogositvanyszam = jogositvanyszam;
        Nev = nev;
        Lakcim = lakcim;
        Gepjarmuvek = gepjarmuvek;
    }
    public Tulajdonos(){
        Logger.info("Noarg Tu!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    public Set<Gepjarmu> getGepjarmuvek() {
        return Gepjarmuvek;
    }

    public void setGepjarmuvek(Set<Gepjarmu> gepjarmuvek) {
        Gepjarmuvek = gepjarmuvek;
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
