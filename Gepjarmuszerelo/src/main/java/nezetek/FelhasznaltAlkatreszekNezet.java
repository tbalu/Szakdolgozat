package nezetek;

import entities.FelhasznaltAlkatresz;

import java.util.ArrayList;
import java.util.List;

public class FelhasznaltAlkatreszekNezet {

    public static List<FelhasznaltAlkatreszekNezet> of(List<FelhasznaltAlkatresz> felhasznaltAlkatreszek){

        List<FelhasznaltAlkatreszekNezet> felhasznaltAlkatreszekNezetek = new ArrayList<>();

        for(FelhasznaltAlkatresz felhasznaltAlkatresz: felhasznaltAlkatreszek){
            felhasznaltAlkatreszekNezetek.add(new FelhasznaltAlkatreszekNezet(felhasznaltAlkatresz));


        }

        return felhasznaltAlkatreszekNezetek;
    }

    private Integer id;
    private String nev;
    private Integer ar;
    private Integer garanciaIdotartama;
    private Integer cikkszam;


    public FelhasznaltAlkatreszekNezet(FelhasznaltAlkatresz felhasznaltAlkatresz){

        this.id = felhasznaltAlkatresz.getId();
        // DEMETER TORVENYENEK MEGSERTESE
        this.nev = felhasznaltAlkatresz.getAlkatresz().getNev();
        this.ar = felhasznaltAlkatresz.getAlkatresz().getAr();
        this.garanciaIdotartama = felhasznaltAlkatresz.getAlkatresz().getGaranciaIdotartama();
        this.cikkszam = felhasznaltAlkatresz.getCikkszam();
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

    public Integer getGaranciaIdotartama() {
        return garanciaIdotartama;
    }

    public void setGaranciaIdotartama(Integer garanciaIdotartama) {
        this.garanciaIdotartama = garanciaIdotartama;
    }

    public Integer getCikkszam() {
        return cikkszam;
    }

    public void setCikkszam(Integer cikkszam) {
        this.cikkszam = cikkszam;
    }
}
