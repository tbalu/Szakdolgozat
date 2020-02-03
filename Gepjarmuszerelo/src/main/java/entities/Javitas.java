package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("J")
public class Javitas extends OsJavitas{

    public Javitas(){}


    public Javitas(String leiras, Integer ar) {
        super(leiras, ar);
    }
}
