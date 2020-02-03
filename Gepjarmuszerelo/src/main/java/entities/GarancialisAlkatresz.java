package entities;

import javax.persistence.*;

//@PrimaryKeyJoinColumn(name = "garancialis_alkatresz_tipus_id")
@Entity(name  = "garancialis_alkatresz")
public class GarancialisAlkatresz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "garancialis_alkatresz_tipus_id")
    private GarancialisAlkatreszTipus garancialisAlkatreszTipus;

    @Column(name = "ar")
    private Integer ar;

    @Column(name = "cikkszam")
    private Integer cikkSzam;

    public GarancialisAlkatresz() {
    }

    public GarancialisAlkatresz(GarancialisAlkatreszTipus garancialisAlkatreszTipus, Integer ar, Integer cikkSzam) {
        this.garancialisAlkatreszTipus = garancialisAlkatreszTipus;
        this.ar = ar;
        this.cikkSzam = cikkSzam;
    }

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
    }
}
