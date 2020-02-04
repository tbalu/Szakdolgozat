package entities;

import javax.persistence.*;

//@PrimaryKeyJoinColumn(name = "garancialis_alkatresz_tipus_id")
@Entity(name  = "garancialis_alkatresz")
@DiscriminatorValue("GA")
public class GarancialisAlkatresz extends OsAlkatresz{
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "garancialis_alkatresz_tipus_id")
    private GarancialisAlkatreszTipus garancialisAlkatreszTipus;
/*
    @Column(name = "ar")
    private Integer ar;

    @Column(name = "cikkszam")
    private Integer cikkSzam;*/

    public GarancialisAlkatresz() {
    }
/*
    public GarancialisAlkatresz(GarancialisAlkatreszTipus garancialisAlkatreszTipus, Integer ar, Integer cikkSzam) {
        this.garancialisAlkatreszTipus = garancialisAlkatreszTipus;
        this.ar = ar;
        this.cikkSzam = cikkSzam;
    }*/

    public GarancialisAlkatresz(String nev, Integer cikkszam, Integer ar, OsJavitas javitas, GarancialisAlkatreszTipus garancialisAlkatreszTipus) {
        super(nev, cikkszam, ar, javitas);
        this.garancialisAlkatreszTipus = garancialisAlkatreszTipus;
    }


    public GarancialisAlkatreszTipus getGarancialisAlkatreszTipus() {
        return garancialisAlkatreszTipus;
    }

    public void setGarancialisAlkatreszTipus(GarancialisAlkatreszTipus garancialisAlkatreszTipus) {
        this.garancialisAlkatreszTipus = garancialisAlkatreszTipus;
    }

    /*
    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    public Integer getCikkSzam() {
        return cikkSzam;
    }

    public void setCikkSzam(Integer cikkSzam) {
        this.cikkSzam = cikkSzam;
    }*/
}
