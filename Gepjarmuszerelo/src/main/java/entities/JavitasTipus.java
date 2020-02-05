package entities;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("J")
public class JavitasTipus extends OsJavitasTipus {

    public JavitasTipus(){}
    public JavitasTipus(String leiras) {
        super( leiras);
    }


}
