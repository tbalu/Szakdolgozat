package entities;

import org.pmw.tinylog.Logger;

import javax.persistence.*;
import java.util.HashSet;
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
    private String jogositvanyszam;

    @Column(name = "nev")
    private String nev;

    @Column(name = "lakcim")
    private String lakcim;
/*
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tulajdonos")
    private List<Gepjarmu> Gepjarmuvek = new ArrayList<>();*/
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "tulajdonos", fetch = FetchType.LAZY)
    private Set<Gepjarmu> Gepjarmuvek = new HashSet<>();

    @Override
    public String toString() {
        return "Tulajdonos{" +
                "nev='" + nev + '\'' +
                ", lakcim='" + lakcim + '\'' +
                ", jogositvanyszam='" + jogositvanyszam + '\'' +
                '}';
    }

    public Tulajdonos(String nev, String lakcim, String jogositvanyszam) {
        this.nev = nev;
        this.lakcim = lakcim;
        this.jogositvanyszam = jogositvanyszam;

    }

    public Tulajdonos(String jogositvanyszam, String nev, String lakcim, Set<Gepjarmu> gepjarmuvek) {
        this.jogositvanyszam = jogositvanyszam;
        this.nev = nev;
        this.lakcim = lakcim;
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
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getJogositvanyszam() {
        return jogositvanyszam;
    }

    public void setJogositvanyszam(String jogositvanyszam) {
        this.jogositvanyszam = jogositvanyszam;
    }

    public String getLakcim() {
        return lakcim;
    }

    public void setLakcim(String lakcim) {
        this.lakcim = lakcim;
    }
}
