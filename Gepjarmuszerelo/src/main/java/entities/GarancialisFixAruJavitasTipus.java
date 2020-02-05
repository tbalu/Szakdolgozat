package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("GFJ")
public class GarancialisFixAruJavitasTipus extends OsJavitasTipus {

    @Column(name="garancia_idotartama")
    private Integer garanciaIdoTartama;
    @Column(name = "fix_ar")
    private Integer fixAr;

    public GarancialisFixAruJavitasTipus() {}

    public GarancialisFixAruJavitasTipus(String leiras, Integer garanciaIdoTartama, Integer fixAr) {
        super(leiras);
        this.garanciaIdoTartama = garanciaIdoTartama;
        this.fixAr = fixAr;
    }

    public Integer getGaranciaIdoTartama() {
        return garanciaIdoTartama;
    }

    public void setGaranciaIdoTartama(Integer garanciaIdoTartama) {
        this.garanciaIdoTartama = garanciaIdoTartama;
    }

    public Integer getFixAr() {
        return fixAr;
    }

    public void setFixAr(Integer fixAr) {
        this.fixAr = fixAr;
    }
}
