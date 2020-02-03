package entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
public class Alkatresz extends OsAlkatresz {

    public Alkatresz(String nev, Integer cikkSzam, Integer ar, OsJavitas javitas) {
        super(nev, cikkSzam, ar, javitas);
    }

    public Alkatresz() {
    }
}
