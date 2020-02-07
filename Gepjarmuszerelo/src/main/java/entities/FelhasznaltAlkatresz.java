package entities;

import javax.persistence.*;

@Entity(name = "eladott_alkatresz")
public class FelhasznaltAlkatresz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alkatresz_id")
    private Alkatresz alkatresz;

    @Column(name = "cikkszam")
    private Integer cikkszam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "javitas_id")
    private Javitas javitas;

    public FelhasznaltAlkatresz(){}

    public FelhasznaltAlkatresz(Integer cikkszam, Alkatresz alkatresz, Javitas javitas) {
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

    public Alkatresz getAlkatresz() {
        return alkatresz;
    }

    public void setAlkatresz(Alkatresz alkatresz) {
        this.alkatresz = alkatresz;
    }

    public Integer getCikkszam() {
        return cikkszam;
    }

    public void setCikkszam(Integer cikkszam) {
        this.cikkszam = cikkszam;
    }

    public Javitas getJavitas() {
        return javitas;
    }

    public void setJavitas(Javitas javitas) {
        this.javitas = javitas;
    }
}
