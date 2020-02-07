package nezetek;

public class FelhsznaltAlkatreszekNezet {


    private String leiras;
    private Integer munkaOra;
    private Integer ar;
    private Integer garanciaIdotartama;

    public FelhsznaltAlkatreszekNezet(String leiras, Integer munkaOra, Integer ar, Integer garanciaIdotartama) {
        this.leiras = leiras;
        this.munkaOra = munkaOra;
        this.ar = ar;
        this.garanciaIdotartama = garanciaIdotartama;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public Integer getMunkaOra() {
        return munkaOra;
    }

    public void setMunkaOra(Integer munkaOra) {
        this.munkaOra = munkaOra;
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
}
