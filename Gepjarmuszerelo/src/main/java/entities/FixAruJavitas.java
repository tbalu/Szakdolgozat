package entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("FAJ")
public class FixAruJavitas extends Javitas {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "javitas_tipus_id")
    private FixAruJavitasTipus fixAruJavitasTipus;


    public FixAruJavitas(){}

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
