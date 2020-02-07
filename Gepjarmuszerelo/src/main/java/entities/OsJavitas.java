package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "javitas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@org.hibernate.annotations.DiscriminatorFormula(
        "case when fix_ar is not null then 'FAJ' else 'ODJ'"
)
public abstract class OsJavitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "javitas", fetch = FetchType.LAZY)
    protected List<FelhasznaltAlkatresz> felhasznaltAlkatreszek = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "dolgozott_rajta",
            joinColumns = @JoinColumn(name = "javitas_id"),
            inverseJoinColumns = @JoinColumn(name = "szerelo_id")

    )
    protected List<Szerelo> szerelok = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "szereles_id")
    protected Szereles szereles;

    //---------------
  /*
    private List<Alkatresz> alkatreszek;
    private List<GarancialisAlkatresz> garancialisAlkatreszek;
*/
    public OsJavitas() {}

    public OsJavitas(String leiras, List<FelhasznaltAlkatresz> felhasznaltAlkatreszek, Szereles szereles) {

        this.felhasznaltAlkatreszek = felhasznaltAlkatreszek;
        this.szereles = szereles;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Szerelo> getSzerelok() {
        return szerelok;
    }

    public void setSzerelok(List<Szerelo> szerelok) {
        this.szerelok = szerelok;
    }

    public List<FelhasznaltAlkatresz> getFelhasznaltAlkatreszek() {
        return felhasznaltAlkatreszek;
    }

    public void setFelhasznaltAlkatreszek(List<FelhasznaltAlkatresz> felhasznaltAlkatreszek) {
        this.felhasznaltAlkatreszek = felhasznaltAlkatreszek;
    }

    public Szereles getSzereles() {
        return szereles;
    }

    public void setSzereles(Szereles szereles) {
        this.szereles = szereles;
    }


    public abstract Integer munkavegzesKoltsegenekKiszamitasa();

}
