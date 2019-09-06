package entities;

import javax.persistence.*;

@Entity
@Table(name = "alkatresz")
public class Alkatresz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "nev")
    private String nev;
    @Column(nullable = false, name = "ar")
    private Integer ar;

    public Alkatresz(){

    }

    public Alkatresz(String nev, Integer ar) {
        this.nev = nev;
        this.ar = ar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }
}
