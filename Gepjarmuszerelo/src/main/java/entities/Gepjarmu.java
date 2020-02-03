package entities;

import org.pmw.tinylog.Logger;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
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

    //@Column(name = "rendszam")
   // private String rendszam;

    @Column(name = "tipus")
    private String tipus;

    @Column(name = "motor_terfogat")
    private Integer motorTerfogat;

    @Column(name = "teljesitmeny")
    private Integer teljesitmeny;

    @Column(name = "vizsga_lejarta")
    private LocalDate vizsgaLejarta;


    @Column(name =  "evjarat")
    private Integer evjarat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tulajdonos_id")
    private Tulajdonos tulajdonos;


    @OneToMany(mappedBy = "gepjarmu", fetch = FetchType.LAZY)
    private List<Szereles> szerelesek;



    public Gepjarmu(){
        Logger.info("Noarg gepjarmu");
    }
    public Gepjarmu(String tipus, String rendszam, Tulajdonos tulajdonos) {
        this.tipus = tipus;
        //this.rendszam = rendszam;
        this.tulajdonos = tulajdonos;

    }

    public Gepjarmu(String rendszam, String tipus, Set<Szereles> szerelesek, Tulajdonos tulajdonos) {
       // this.rendszam = rendszam;
        this.tipus = tipus;
        this.szerelesek = new ArrayList<>();
        this.tulajdonos = tulajdonos;
    }

    public Gepjarmu(String tipus, Integer motorTerfogat, Integer teljesitmeny, LocalDate vizsgaLejarta, Integer evjarat, Tulajdonos tulajdonos, List<Szereles> szerelesek) {
        //this.rendszam = rendszam;
        this.tipus = tipus;
        this.motorTerfogat = motorTerfogat;
        this.teljesitmeny = teljesitmeny;
        this.vizsgaLejarta = vizsgaLejarta;
        this.evjarat = evjarat;
        this.tulajdonos = tulajdonos;
        this.szerelesek = szerelesek;
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

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    /*
    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }*/

    public Integer getMotorTerfogat() {
        return motorTerfogat;
    }

    public void setMotorTerfogat(Integer motorTerfogat) {
        this.motorTerfogat = motorTerfogat;
    }

    public Integer getTeljesitmeny() {
        return teljesitmeny;
    }

    public void setTeljesitmeny(Integer teljesitmeny) {
        this.teljesitmeny = teljesitmeny;
    }

    public LocalDate getVizsgaLejarta() {
        return vizsgaLejarta;
    }

    public void setVizsgaLejarta(LocalDate vizsgaLejarta) {
        this.vizsgaLejarta = vizsgaLejarta;
    }

    public Integer getEvjarat() {
        return evjarat;
    }

    public void setEvjarat(Integer evjarat) {
        this.evjarat = evjarat;
    }

    @Override
    public String toString() {
        return "Gepjarmu{" +
                "tipus='" + tipus + '\'' +
                ", motorTerfogat=" + motorTerfogat +
                ", teljesitmeny=" + teljesitmeny +
                ", vizsgaLejarta=" + vizsgaLejarta +
                ", evjarat=" + evjarat +
                ", tulajdonos=" + tulajdonos +
                ", szerelesek=" + szerelesek +
                '}';
    }
}
