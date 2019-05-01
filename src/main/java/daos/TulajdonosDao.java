package daos;

import com.google.inject.persist.Transactional;
import entities.Gepjarmu;
import entities.Szereles;
import entities.Tulajdonos;
import jpa.GenericJpaDao;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.criteria.internal.path.ListAttributeJoin;
import org.pmw.tinylog.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.RollbackException;
import java.util.Optional;

public class TulajdonosDao extends GenericJpaDao<Tulajdonos> {


    public TulajdonosDao(){
        super(Tulajdonos.class);
    }


    public void addGepjarmuvekhez(Gepjarmu gepjarmu, Tulajdonos tulajdonos) {
        try {
            this.addGepjarmuvekhezSeged(gepjarmu.getMarka(),gepjarmu.getRendszam(), tulajdonos.getJogositvanyszam());
        }catch (ConstraintViolationException r){
            Logger.info("Már van ilyen autó");
            System.out.println("-----------------------------------------------------------------------------------");
        }
        catch(RollbackException r){
            Logger.info("Mar van ilyen auto");
        }
    }
        //valtoztatok
    public void addGepjarmuvekhez(String Marka, String Rendszam, String TulajdonosJogositvanyszama) {
        try {
        this.addGepjarmuvekhezSeged(Marka,Rendszam,TulajdonosJogositvanyszama);
    }catch (ConstraintViolationException r){
        Logger.info("Már van ilyen autó");
        System.out.println("-----------------------------------------------------------------------------------");
        }
        catch(RollbackException r){
            Logger.info("Mar van ilyen auto");
        }
    }
    @Transactional
    private void addGepjarmuvekhezSeged(String Marka, String Rendszam, String TulajdonosJogositvanyszama) throws ConstraintViolationException {

            this.find(TulajdonosJogositvanyszama).ifPresent(c -> c.getGepjarmuvek().add(new Gepjarmu(Rendszam, Marka, null, c)));

    }
    @Transactional
    public void addGepjarmuvekhezRossz(String Marka, String Rendszam, String TulajdonosJogositvanyszama){

        this.find(TulajdonosJogositvanyszama).ifPresent(c -> c.getGepjarmuvek().add(new Gepjarmu(Rendszam, Marka, null, c)));

    }
    @Transactional
    public void save(Tulajdonos t){
        try{
        super.persist(t);
        }catch (ConstraintViolationException c){
            Logger.info("Mar van ilyen kulcsu elem");
        }catch (RollbackException r){
            Logger.info("Mar van ilyen kulcsu elem");
        }
    }

    public Optional<Tulajdonos> ffind(String kulcs){
        entityManager.getTransaction().begin();
        Optional<Tulajdonos> t  = Optional.ofNullable(entityManager.find(Tulajdonos.class,kulcs));
        entityManager.getTransaction().commit();
        Logger.info(t);
        return t;
    }

    public void tulajdonostMent(Tulajdonos tulajdonos){
        if(this.entityManager.getTransaction().isActive()){
        this.entityManager.getTransaction().begin();}
        try{
        this.entityManager.persist(tulajdonos);

        if(entityManager.getTransaction().isActive())
        this.entityManager.getTransaction().commit();

    }
        catch (EntityExistsException e){
            Logger.info("Mar van ilen");
        }
        catch (RollbackException r){
            this.entityManager.getTransaction().rollback();
            this.entityManager.getTransaction().commit();
            Logger.info("Mar van ilyen kulcsu objektum");
        }
    }

    public void ujTulajEsGepjarmu(Tulajdonos tulajdonos, Gepjarmu gepjarmu ){
        tulajdonos.getGepjarmuvek().add(gepjarmu);
        this.entityManager.getTransaction().begin();
        try{
        this.entityManager.persist(tulajdonos);}
        catch (EntityExistsException e){
            Logger.info("Ilyen entitas mar letezik");
        }
        //this.addGepjarmuvekhez(gepjarmu.getMarka(),gepjarmu.getRendszam(),tulajdonos.getJogositvanyszam());
        try{
            this.entityManager.getTransaction().commit();
        }catch (RollbackException r){
            Logger.info("Valamibol mar van");
        }
        catch (ConstraintViolationException c){
            Logger.info("Valamibol mar van");
        }

    }
    public void ujSzereles(Tulajdonos tulajdonos, Gepjarmu gepjarmu){

    }
}
