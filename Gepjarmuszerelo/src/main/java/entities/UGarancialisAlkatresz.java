package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/*
@Entity
@DiscriminatorValue("GA")*/
public class UGarancialisAlkatresz extends OsAlkatresz {

    private Integer garanciaIdotartama;

    public UGarancialisAlkatresz(String nev, Integer cikkszam, Integer ar, OsJavitas javitas) {
        super(nev, cikkszam, ar, javitas);
    }

    public UGarancialisAlkatresz() {
    }

    public Integer getGaranciaIdotartama() {
        return garanciaIdotartama;
    }

    public void setGaranciaIdotartama(Integer garanciaIdotartama) {
        this.garanciaIdotartama = garanciaIdotartama;
    }
}
