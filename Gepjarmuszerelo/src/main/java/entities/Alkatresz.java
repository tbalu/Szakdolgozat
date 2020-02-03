package entities;

import javax.persistence.*;

@Entity
public class Alkatresz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nev")
    private String nev;

    @Column(name = "cikk_szam")
    private String cikkSzam;

    @Column(name = "ar")
    private Integer ar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "szereles_id")
    private Szereles szereles;

    public Alkatresz(String nev, String cikkSzam, Integer ar, Szereles szereles) {
        this.nev = nev;
        this.cikkSzam = cikkSzam;
        this.ar = ar;
        this.szereles = szereles;
    }

    public Alkatresz(){}

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

    public String getCikkSzam() {
        return cikkSzam;
    }

    public void setCikkSzam(String cikkSzam) {
        this.cikkSzam = cikkSzam;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    public Szereles getGepjarmu() {
        return szereles;
    }

    public void setGepjarmu(Szereles szereles) {
        this.szereles = szereles;
    }
}
