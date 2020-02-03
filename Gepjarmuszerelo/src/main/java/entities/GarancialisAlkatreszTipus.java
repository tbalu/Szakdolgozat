package entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "garancialis_alkatresz_tipus")
//@Inheritance(strategy = InheritanceType.JOINED)
public class GarancialisAlkatreszTipus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nev")
    private String nev;

    @Column(name = "garancia_idotartama")
    private Integer garanciaIdotartama;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garancialisAlkatreszTipus", fetch = FetchType.LAZY)
    private List<GarancialisAlkatresz> garancialisAlkatreszek ;

    public GarancialisAlkatreszTipus() {
    }

    public GarancialisAlkatreszTipus(String nev, Integer garanciaIdotartama) {
        this.nev = nev;
        this.garanciaIdotartama = garanciaIdotartama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getGaranciaIdotartama() {
        return garanciaIdotartama;
    }

    public void setGaranciaIdotartama(Integer garanciaIdotartama) {
        this.garanciaIdotartama = garanciaIdotartama;
    }

    public List<GarancialisAlkatresz> getGarancialisAlkatreszek() {
        return garancialisAlkatreszek;
    }

    public void setGarancialisAlkatreszek(List<GarancialisAlkatresz> garancialisAlkatreszek) {
        this.garancialisAlkatreszek = garancialisAlkatreszek;
    }
}
