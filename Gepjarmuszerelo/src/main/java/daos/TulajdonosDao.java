package daos;

import com.querydsl.jpa.impl.JPAQueryFactory;
import entities.QTulajdonos;
import entities.Tulajdonos;
import org.pmw.tinylog.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TulajdonosDao extends BasicDao<Tulajdonos> {


    public TulajdonosDao(){
        super(Tulajdonos.class);
    }
    public TulajdonosDao(EntityManager entityManager){
        super(Tulajdonos.class);
        this.em =entityManager;

    }

/*

    public void ment(Tulajdonos tulajdonos){
        Tulajdonos lekerdezettTulajdonos = this.getByJogositvanyszam(tulajdonos.getTelefonszam());
        Logger.info(lekerdezettTulajdonos);
        if(lekerdezettTulajdonos==null){
            Logger.info("ifben");
            this.persist(tulajdonos);
        }
        else{
            Logger.info("elseben");
            this.em.getTransaction().begin();
            tulajdonos.setId(lekerdezettTulajdonos.getId());
            this.em.merge(tulajdonos);
            this.em.getTransaction().commit();
        }
    }
*/
    //---------------------------------------------------------------
  /*  Tulajdonos getByJogositvanyszam(String jogositvanyszam){
        JPAQueryFactory queryFactory = new JPAQueryFactory(this.em);
        QTulajdonos qTulajdonos = QTulajdonos.tulajdonos;
        Tulajdonos tnev = queryFactory.selectFrom(qTulajdonos)
                .where(qTulajdonos.jogositvanyszam.eq(jogositvanyszam))
                .fetchFirst();
    return tnev;
    }
*/
  //-------------------------------------------------------------------
    public List<Tulajdonos> getAll(){

        Query query = this.em.createQuery("from Tulajdonos T");
        return query.getResultList();

    }

    public List<String> getAllJogositvanyszam(){

        //return this.getAll().stream().map(Tulajdonos::getTelefonszam).collect(Collectors.toList());

        Query query = em.createQuery(
                "select i.jogositvanyszam from Tulajdonos i");
        return query.getResultList();
    }

    public List<String> getAllNev(){

        //return this.getAll().stream().map(Tulajdonos::getTelefonszam).collect(Collectors.toList());

        Query query = em.createQuery(
                "select i.nev from Tulajdonos i");
        return query.getResultList();
    }

    public List<Tulajdonos> getByNev(String nev){

        Query query = em.createQuery(
                "select t from Tulajdonos t where t.nev = :nev"
        ).setParameter("nev", nev);

        return query.getResultList();

    }

    /*public void tulajdonosGepjarmuinekTorlese(Tulajdonos tulajdonos){

        if(tulajdonos.getGepjarmuvek().size() > 0) {
            for (Gepjarmu gepjarmu : tulajdonos.getGepjarmuvek()) {

                this.remove(this.getById(gepjarmu.getId()));
            }
        }

    }*/


    /* TODO  teszt*/

    //public List<>



}
