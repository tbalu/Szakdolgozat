package entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "szerelesekhez_hasznalt_alkatresz")
public class SzereleshezHasznaltAlkatresz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "szereles_id", referencedColumnName = "id")
    private Szereles szereles;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "alkatresz_id", referencedColumnName = "id")
    private Alkatresz alkatresz;

    @Column(name = "mennyiseg")
    private Integer mennyiseg;

    @Column(name = "alkatresz_ara")
    private Integer alkatreszAra;
    public SzereleshezHasznaltAlkatresz(){}

    public SzereleshezHasznaltAlkatresz(Szereles szereles, Alkatresz alkatresz, Integer mennyiseg, Integer alkatreszAra) {
        this.szereles = szereles;
        this.alkatresz = alkatresz;
        this.mennyiseg = mennyiseg;
        this.alkatreszAra = alkatreszAra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Szereles getSzereles() {
        return szereles;
    }

    public void setSzereles(Szereles szereles) {
        this.szereles = szereles;
    }

    public Alkatresz getAlkatresz() {
        return alkatresz;
    }

    public void setAlkatresz(Alkatresz alkatresz) {
        this.alkatresz = alkatresz;
    }

    public Integer getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(Integer mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public Integer getAlkatreszAra() {
        return alkatreszAra;
    }

    public void setAlkatreszAra(Integer alkatreszAra) {
        this.alkatreszAra = alkatreszAra;
    }
}
