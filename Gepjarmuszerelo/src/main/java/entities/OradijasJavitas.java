package entities;

import javax.persistence.*;


@Entity
@DiscriminatorValue("ODJ")
public class OradijasJavitas extends Javitas {



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "javitas_tipus_id")
    private OradijasJavitasTipus oradijasJavitasTipus;

    @Column(name = "munkaorak_szama")
    private Integer munkaOrakSzama;

    public OradijasJavitas(){}

    public OradijasJavitas(Szereles szereles, OradijasJavitasTipus oradijasJavitasTipus, Integer munkaOrakSzama) {
        this.szereles = szereles;
        this.oradijasJavitasTipus = oradijasJavitasTipus;
        this.munkaOrakSzama = munkaOrakSzama;
    }

    @Override
    public Integer munkavegzesKoltsegenekKiszamitasa() {
        return null;
    }

    public OradijasJavitasTipus getOradijasJavitasTipus() {
        return oradijasJavitasTipus;
    }

    public void setOradijasJavitasTipus(OradijasJavitasTipus oradijasJavitasTipus) {
        this.oradijasJavitasTipus = oradijasJavitasTipus;
    }

    public Integer getMunkaOrakSzama() {
        return munkaOrakSzama;
    }

    public void setMunkaOrakSzama(Integer munkaOrakSzama) {
        this.munkaOrakSzama = munkaOrakSzama;
    }
}
