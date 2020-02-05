package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("GJ")
public class GarancialisJavitasTipus extends OsJavitasTipus {

    @Column(name = "garancia_idotartama")
    private Integer garanciaIdotartama;

    public GarancialisJavitasTipus() {}

    public GarancialisJavitasTipus( String leiras, Integer garanciaIdotartama) {
        super( leiras);
        this.garanciaIdotartama = garanciaIdotartama;
    }
}
