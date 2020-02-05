package entities;

import javax.persistence.*;

@Entity(name = "javitas_tipus")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@org.hibernate.annotations.DiscriminatorFormula(
        "case when garancia_idotartama is not null and fix_ar is null then 'GJ'" +
                "case when garancia_idotartama is null and fix_ar is not null then 'FJ'" +
                "case when garancia_idotartama is null and fix_ar is null then 'J'" +
                "case when garancia_idotartama is not null and fix_ar is not null then 'GFJ' end"
)
public abstract class OsJavitasTipus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "leiras")
    private String leiras;

    public OsJavitasTipus(){}

    public OsJavitasTipus(String leiras) {

        this.leiras = leiras;
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
}
