package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tulajdonos {

    @Id
    @Column(name = "jogositvanyszam")
    private String Jogositvanyszam;

    @Column(name = "nev")
    private String Nev;

    @Column(name = "lakcim")
    private String Lakcim;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tulajdonos")
    private List<Gepjarmu> Gepjarmuvek = new ArrayList<>();


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

    public Tulajdonos(String jogositvanyszam, String nev, String lakcim, List<Gepjarmu> gepjarmuvek) {
        Jogositvanyszam = jogositvanyszam;
        Nev = nev;
        Lakcim = lakcim;
        Gepjarmuvek = gepjarmuvek;
    }
    public Tulajdonos(){}
    public List<Gepjarmu> getGepjarmuvek() {
        return Gepjarmuvek;
    }

    public void setGepjarmuvek(List<Gepjarmu> gepjarmuvek) {
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
