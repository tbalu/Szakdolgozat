package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("GJ")
public class GarancialisJavitas extends OsJavitas {

    public GarancialisJavitas(String leiras, Integer ar, Integer garanciaIdotartama) {
        super(leiras, ar);
        this.garanciaIdotartama = garanciaIdotartama;
    }

    @Column(name = "garancia_idotartama")
    private Integer garanciaIdotartama;


}
