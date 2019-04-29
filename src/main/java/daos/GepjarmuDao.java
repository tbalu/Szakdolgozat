package daos;

import com.google.inject.persist.Transactional;
import entities.Gepjarmu;
import entities.Szereles;
import entities.Tulajdonos;
import jpa.GenericJpaDao;

public class GepjarmuDao extends GenericJpaDao<Gepjarmu> {

    public GepjarmuDao(){
        super(Gepjarmu.class);
    }
    @Transactional
    public void addSzerelesekhez(Gepjarmu g, Szereles sz){
        g.getSzerelesek().add(sz);
    }
}