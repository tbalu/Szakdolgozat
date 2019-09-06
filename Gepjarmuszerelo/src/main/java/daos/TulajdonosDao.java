package daos;

import com.google.inject.persist.Transactional;
import com.querydsl.jpa.impl.JPAQueryFactory;
import entities.Gepjarmu;
import entities.QTulajdonos;
import entities.Szereles;
import entities.Tulajdonos;
import jpa.GenericJpaDao;
import org.hibernate.exception.ConstraintViolationException;
import org.pmw.tinylog.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class TulajdonosDao extends BasicDao<Tulajdonos> {


    public TulajdonosDao(){
        super(Tulajdonos.class);
    }
    public TulajdonosDao(EntityManager entityManager){
        super(Tulajdonos.class);
        this.entityManager =entityManager;

    }



    public void ment(Tulajdonos tulajdonos){
        Tulajdonos lekerdezettTulajdonos = this.getByJogositvanyszam(tulajdonos.getJogositvanyszam());
        Logger.info(lekerdezettTulajdonos);
        if(lekerdezettTulajdonos==null){
            Logger.info("ifben");
            this.persist(tulajdonos);
        }
        else{
            Logger.info("elseben");
            this.entityManager.getTransaction().begin();
            tulajdonos.setId(lekerdezettTulajdonos.getId());
            this.entityManager.merge(tulajdonos);
            this.entityManager.getTransaction().commit();
        }
    }

    Tulajdonos getByJogositvanyszam(String jogositvanyszam){
        JPAQueryFactory queryFactory = new JPAQueryFactory(this.entityManager);
        QTulajdonos qTulajdonos = QTulajdonos.tulajdonos;
        Tulajdonos tnev = queryFactory.selectFrom(qTulajdonos)
                .where(qTulajdonos.Jogositvanyszam.eq(jogositvanyszam))
                .fetchFirst();
    return tnev;
    }

    public List<Tulajdonos> getAll(){

        Query query = this.entityManager.createQuery("from Tulajdonos T");
        return query.getResultList();

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
        this.entityManager.persist(tulajdonos);
        }
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
        Szereles szereles = new Szereles();
        szereles.setSzerelesKezdete(LocalDate.now());
        szereles.setMunkavegzesKoltsege(34);
        gepjarmu.getSzerelesek().add(szereles);
        tulajdonos.getGepjarmuvek().add(gepjarmu);

        this.entityManager.getTransaction().begin();
        try{
            this.entityManager.persist(tulajdonos);
           /* this.entityManager.persist(gepjarmu);
        this.entityManager.persist(szereles);*/
        }
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
    public void ujSzerelesPerfekt(Tulajdonos tulajdonos, Gepjarmu gepjarmu){
        Optional<Tulajdonos> ujTulaj = this.ffind(tulajdonos.getJogositvanyszam());
        if(!ujTulaj.isPresent()){
            this.ujSzereles(tulajdonos,gepjarmu);
        }
        else{

            gepjarmu.getSzerelesek().add(new Szereles(gepjarmu,LocalDate.now(),null,null));
            ujTulaj.get().getGepjarmuvek().add(gepjarmu);
            this.entityManager.getTransaction().begin();
            this.entityManager.getTransaction().commit();
        }

    }
}
