package entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gepjarmu {

    @Id
    @Column(name = "rendszam")
    private String Rendszam;

    @Column(name = "marka")
    private String Marka;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tulajdonos_jogositvanyszama")
    private Tulajdonos tulajdonos;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Szereles> Szerelesek;



    public Gepjarmu(){}
    public Gepjarmu(String marka, String rendszam, Tulajdonos tulajdonos) {
        Marka = marka;
        Rendszam = rendszam;
        this.tulajdonos = tulajdonos;

    }

    public Gepjarmu(String rendszam, String marka, List<Szereles> szerelesek, Tulajdonos tulajdonos) {
        Rendszam = rendszam;
        Marka = marka;
        Szerelesek = new ArrayList<Szereles>();
        this.tulajdonos = tulajdonos;
    }

    public List<Szereles> getSzerelesek() {
        return Szerelesek;
    }

    public void setSzerelesek(List<Szereles> szerelesek) {
        Szerelesek = szerelesek;
    }

    public entities.Tulajdonos getTulajdonos() {
        return tulajdonos;
    }

    public void setTulajdonos(entities.Tulajdonos tulajdonos) {
        tulajdonos = tulajdonos;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public String getRendszam() {
        return Rendszam;
    }

    public void setRendszam(String rendszam) {
        Rendszam = rendszam;
    }

    @Override
    public String toString() {
        return "Gepjarmu{" +
                "Marka='" + Marka + '\'' +
                ", Rendszam='" + Rendszam + '\'' +
                ", Tulajdonos='" + tulajdonos.getNev() + '\'' +
                '}';
    }
}
