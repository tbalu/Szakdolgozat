package entities;

import javax.persistence.*;

@Entity
public class Alkatresz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nev")
    private String nev;

    @Column(name = "vonalkod")
    private String vonalkod;

    @Column(name = "ar")
    private Integer ar;

    @ManyToOne
    @JoinColumn(name = "szereles_id")
    private Szereles szereles;

    public Alkatresz(String nev, String vonalkod, Integer ar, Szereles szereles) {
        this.nev = nev;
        this.vonalkod = vonalkod;
        this.ar = ar;
        this.szereles = szereles;
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

    public String getVonalkod() {
        return vonalkod;
    }

    public void setVonalkod(String vonalkod) {
        this.vonalkod = vonalkod;
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
