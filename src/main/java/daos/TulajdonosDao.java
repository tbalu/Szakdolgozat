package daos;

import com.google.inject.persist.Transactional;
import entities.Gepjarmu;
import entities.Szereles;
import entities.Tulajdonos;
import jpa.GenericJpaDao;
import org.pmw.tinylog.Logger;

import javax.persistence.RollbackException;

public class TulajdonosDao extends GenericJpaDao<Tulajdonos> {


    public TulajdonosDao(){
        super(Tulajdonos.class);
    }

    public void addGepjarmuvekhez(String Marka, String Rendszam, String TulajdonosJogositvanyszama) {
        try {
        this.addGepjarmuvekhezSeged(Marka,Rendszam,TulajdonosJogositvanyszama);
    }catch (RollbackException r){
        Logger.info("Már van ilyen autó");
        }
    }
    @Transactional
    private void addGepjarmuvekhezSeged(String Marka, String Rendszam, String TulajdonosJogositvanyszama) throws RollbackException{

            this.find(TulajdonosJogositvanyszama).ifPresent(c -> c.getGepjarmuvek().add(new Gepjarmu(Rendszam, Marka, null, c)));

    }
    @Transactional
    public void addSzerelesekhez(String Rendszam, String Jogositvanyszam){
        Szereles sz = new Szereles(Rendszam);
        Tulajdonos t = this.find(Jogositvanyszam).get();
        t.getGepjarmuvek().stream().filter(c->c.getRendszam() == Rendszam).findFirst().get().getSzerelesek().add(sz);
    }
}
