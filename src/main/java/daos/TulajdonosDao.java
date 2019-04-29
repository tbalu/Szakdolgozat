package daos;

import com.google.inject.persist.Transactional;
import entities.Gepjarmu;
import entities.Szereles;
import entities.Tulajdonos;
import jpa.GenericJpaDao;

public class TulajdonosDao extends GenericJpaDao<Tulajdonos> {


    public TulajdonosDao(){
        super(Tulajdonos.class);
    }
    @Transactional
    public void addGepjarmuvekhez(String Marka, String Rendszam, String TulajdonosJogositvanyszama,Tulajdonos tulajdonos){
        this.find(TulajdonosJogositvanyszama).ifPresent(c->c.getGepjarmuvek().add(new Gepjarmu(Marka,Rendszam,null,c)));
        //Tulajdonos t = this.find(TulajdonosJogositvanyszama).get();


        //valtozas tortent


        //Gepjarmu a = new Gepjarmu(Rendszam,Marka,null,TulajdonosJogositvanyszama);
        //tulajdonos.getGepjarmuvek().add(a);
        //a.setMarka(Marka);
    }

    @Transactional
    public void addSzerelesekhez(String Rendszam, String Jogositvanyszam){
        Szereles sz = new Szereles(Rendszam);
        Tulajdonos t = this.find(Jogositvanyszam).get();
        t.getGepjarmuvek().stream().filter(c->c.getRendszam() == Rendszam).findFirst().get().getSzerelesek().add(sz);
    }
}
