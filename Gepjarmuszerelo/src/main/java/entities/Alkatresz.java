package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("A")
public class Alkatresz extends OsAlkatresz {

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "alkatresz", fetch = FetchType.LAZY)
    private List<EladottAlkatresz> eladottAlkatreszek;

    public Alkatresz(String nev, Integer ar, List<EladottAlkatresz> eladottAlkatreszek) {
        super(nev, ar);
        this.eladottAlkatreszek = eladottAlkatreszek;
    }

    public Alkatresz() {
    }
}
