package entities;

import javax.persistence.*;

@Entity(name = "eladott_alkatresz")
public class EladottAlkatresz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Alkatresz alkatresz;

    @Column(name = "cikkszam")
    private Integer cikkszam;

    public EladottAlkatresz(){}

    public EladottAlkatresz(Integer id, Integer cikkszam) {
        this.id = id;
        this.cikkszam = cikkszam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCikkszam() {
        return cikkszam;
    }

    public void setCikkszam(Integer cikkszam) {
        this.cikkszam = cikkszam;
    }
}
