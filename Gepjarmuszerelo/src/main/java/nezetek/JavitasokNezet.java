package nezetek;

import entities.FixAruJavitas;
import entities.OradijasJavitas;
import entities.OsJavitas;

import java.util.ArrayList;
import java.util.List;

public class JavitasokNezet {

    public static List<JavitasokNezet> listaLetrehozasa(List<OsJavitas> javitasok){

        List<JavitasokNezet> javitasokNezetek = new ArrayList<>();

        for(OsJavitas javitas: javitasok){

            if(javitas instanceof OradijasJavitas){
                javitasokNezetek.add(new JavitasokNezet((OradijasJavitas) javitas));
            }
            else if(javitas instanceof FixAruJavitas){

                javitasokNezetek.add(new JavitasokNezet((FixAruJavitas)javitas));

            }

        }

        return javitasokNezetek;

    }

    private String leiras;
    private Integer ar;
    private Integer javitasGaranciaIdotartama;
    private Integer munkaorakSzama;

    public JavitasokNezet(String leiras, Integer ar, Integer javitasGaranciaIdotartama) {
        this.leiras = leiras;
        this.ar = ar;
        this.javitasGaranciaIdotartama = javitasGaranciaIdotartama;
    }

    public JavitasokNezet(FixAruJavitas fixAruJavitas){

        this.ar = fixAruJavitas.getFixAruJavitasTipus().getAr();
        this.leiras = fixAruJavitas.getFixAruJavitasTipus().getLeiras();
        this.javitasGaranciaIdotartama = fixAruJavitas.getFixAruJavitasTipus().getGaranciaIdotartama();


    }

    public JavitasokNezet(OradijasJavitas oradijasJavitas){

        this.javitasGaranciaIdotartama = oradijasJavitas.getOradijasJavitasTipus().getGaranciaIdotartama();
        this.leiras = oradijasJavitas.getOradijasJavitasTipus().getLeiras();
        this.munkaorakSzama = oradijasJavitas.getMunkaOrakSzama();
        this.ar = oradijasJavitas.munkavegzesKoltsegenekKiszamitasa();

    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    public Integer getJavitasGaranciaIdotartama() {
        return javitasGaranciaIdotartama;
    }

    public void setJavitasGaranciaIdotartama(Integer javitasGaranciaIdotartama) {
        this.javitasGaranciaIdotartama = javitasGaranciaIdotartama;
    }
}
