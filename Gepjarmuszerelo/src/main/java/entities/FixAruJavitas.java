package entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("FAJ")
public class FixAruJavitas extends Javitas {

    @ManyToOne(fetch = FetchType.LAZY)
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
