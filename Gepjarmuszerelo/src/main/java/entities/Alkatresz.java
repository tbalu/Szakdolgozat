package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("A")
public class Alkatresz extends OsAlkatresz {

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "alkatresz", fetch = FetchType.LAZY)
    private List<EladottAlkatresz> eladottAlkatreszek = new ArrayList<>();

    public Alkatresz(String nev, Integer ar) {
        super(nev, ar);

    }

    public Alkatresz() {
    }
}
