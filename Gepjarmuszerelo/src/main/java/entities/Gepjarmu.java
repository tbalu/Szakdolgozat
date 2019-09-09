package entities;

import org.pmw.tinylog.Logger;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Gepjarmu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "rendszam")
    private String rendszam;

    @Column(name = "marka")
    private String marka;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tulajdonos_id")
    private Tulajdonos tulajdonos;


    @OneToMany(mappedBy = "gepjarmu", fetch = FetchType.LAZY)
    private List<Szereles> szerelesek;



    public Gepjarmu(){
        Logger.info("Noarg gepjarmu");
    }
    public Gepjarmu(String marka, String rendszam, Tulajdonos tulajdonos) {
        this.marka = marka;
        this.rendszam = rendszam;
        this.tulajdonos = tulajdonos;

    }

    public Gepjarmu(String rendszam, String marka, Set<Szereles> szerelesek, Tulajdonos tulajdonos) {
        this.rendszam = rendszam;
        this.marka = marka;
        this.szerelesek = new ArrayList<>();
        this.tulajdonos = tulajdonos;
    }

    public List<Szereles> getSzerelesek() {
        return szerelesek;
    }

    public void setSzerelesek(List<Szereles> szerelesek) {
        this.szerelesek = szerelesek;
    }

    public entities.Tulajdonos getTulajdonos() {
        return tulajdonos;
    }

    public void setTulajdonos(entities.Tulajdonos tulajdonos) {
        tulajdonos = tulajdonos;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    @Override
    public String toString() {
        return "Gepjarmu{" +
                "marka='" + marka + '\'' +
                ", rendszam='" + rendszam + '\'' +
                ", Tulajdonos='" + tulajdonos.getNev() + '\'' +
                '}';
    }
}
