package entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity(name = "javitas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@org.hibernate.annotations.DiscriminatorFormula(
        "case when garancia_idotartama is not null then 'GJ' else 'J' end"
)
//@DiscriminatorColumn(name = "JAVITAS_TYPE")
public abstract class OsJavitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "leiras")
    private String leiras;
    @Column(name = "ar")
    private Integer ar;

    //---------------

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "javitas", fetch = FetchType.LAZY)
    private List<OsAlkatresz> alkatreszek;

    //---------------
  /*
    private List<Alkatresz> alkatreszek;
    private List<GarancialisAlkatresz> garancialisAlkatreszek;
*/
    public OsJavitas() {}

    public OsJavitas(String leiras, Integer ar/*, List<Alkatresz> alkatreszek, List<GarancialisAlkatresz> garancialisAlkatreszek*/) {
        this.leiras = leiras;
        this.ar = ar;/*
        this.alkatreszek = alkatreszek;
        this.garancialisAlkatreszek = garancialisAlkatreszek;*/
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }
/*
    public List<Alkatresz> getAlkatreszek() {
        return alkatreszek;
    }

    public void setAlkatreszek(List<Alkatresz> alkatreszek) {
        this.alkatreszek = alkatreszek;
    }

    public List<GarancialisAlkatresz> getGarancialisAlkatreszek() {
        return garancialisAlkatreszek;
    }

    public void setGarancialisAlkatreszek(List<GarancialisAlkatresz> garancialisAlkatreszek) {
        this.garancialisAlkatreszek = garancialisAlkatreszek;
    }*/
}
