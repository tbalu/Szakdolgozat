package entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("FAJ")
public class FixAruJavitas extends OsJavitas{

    @ManyToOne(fetch = FetchType.EAGER)
    private FixAruJavitasTipus fixAruJavitasTipus;


    @Override
    public Integer munkavegzesKoltsegenekKiszamitasa() {
        return null;
    }

    public FixAruJavitas(FixAruJavitasTipus fixAruJavitasTipus) {
        this.fixAruJavitasTipus = fixAruJavitasTipus;
    }



    public FixAruJavitasTipus getFixAruJavitasTipus() {
        return fixAruJavitasTipus;
    }

    public void setFixAruJavitasTipus(FixAruJavitasTipus fixAruJavitasTipus) {
        this.fixAruJavitasTipus = fixAruJavitasTipus;
    }
}
