package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("FJ")
public class FixAruJavitasTipus extends OsJavitasTipus {

    @Column(name = "fix_ar")
    private Integer fixAr;
    
    public FixAruJavitasTipus(){}

    public FixAruJavitasTipus( String leiras, Integer fixAr) {
        super(leiras);
        this.fixAr = fixAr;
    }

    public Integer getAr() {
        return fixAr;
    }

    public void setAr(Integer ar) {
        this.fixAr = ar;
    }
}
