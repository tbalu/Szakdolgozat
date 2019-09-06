package entities;

import org.pmw.tinylog.Logger;
import javax.persistence.*;
import java.util.HashSet;
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


    @ManyToOne
    @JoinColumn(name = "tulajdonos_id")
    private Tulajdonos tulajdonos;


    @OneToMany(/*cascade = CascadeType.ALL,*/ mappedBy = "gepjarmu")
    @ElementCollection
    private Set<Szereles> Szerelesek;



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
        Szerelesek = new HashSet<>();
        this.tulajdonos = tulajdonos;
    }

    public Set<Szereles> getSzerelesek() {
        return Szerelesek;
    }

    public void setSzerelesek(Set<Szereles> szerelesek) {
        Szerelesek = szerelesek;
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
