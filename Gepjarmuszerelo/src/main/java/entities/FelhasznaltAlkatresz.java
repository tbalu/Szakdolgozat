package entities;

import javax.persistence.*;

@Entity(name = "eladott_alkatresz")
public class FelhasznaltAlkatresz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alkatresz_id")
    private OsAlkatresz alkatresz;

    @Column(name = "cikkszam")
    private Integer cikkszam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "javitas_id")
    private OsJavitas javitas;

    public FelhasznaltAlkatresz(){}

    public FelhasznaltAlkatresz(Integer cikkszam, OsAlkatresz alkatresz, OsJavitas javitas) {
        this.cikkszam = cikkszam;
        this.alkatresz = alkatresz;
        this.javitas = javitas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OsAlkatresz getAlkatresz() {
        return alkatresz;
    }

    public void setAlkatresz(OsAlkatresz alkatresz) {
        this.alkatresz = alkatresz;
    }

    public Integer getCikkszam() {
        return cikkszam;
    }

    public void setCikkszam(Integer cikkszam) {
        this.cikkszam = cikkszam;
    }

    public OsJavitas getJavitas() {
        return javitas;
    }

    public void setJavitas(OsJavitas javitas) {
        this.javitas = javitas;
    }
}
