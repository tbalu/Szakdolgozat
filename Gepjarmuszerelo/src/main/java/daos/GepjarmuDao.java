package daos;

import com.querydsl.jpa.impl.JPAQueryFactory;
import entities.*;
import entities.QGepjarmu;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GepjarmuDao extends BasicDao<Gepjarmu> {

    public GepjarmuDao(EntityManager entityManager){
        super(Gepjarmu.class);
        this.em = entityManager;
    }
    /*@Transactional
    public void addSzerelesekhez(Gepjarmu g, Szereles sz){
        g.getSzerelesek().add(sz);
    }*/

    public Gepjarmu getByRendszam(String rendszam){
        JPAQueryFactory queryFactory = new JPAQueryFactory(this.em);
        QGepjarmu qGepjarmu = QGepjarmu.gepjarmu;
        Gepjarmu gnev = queryFactory.selectFrom(qGepjarmu)
                .where(qGepjarmu.rendszam.eq(rendszam))
                .fetchFirst();
        return gnev;
    }

    public boolean isExist(Gepjarmu gepjarmu){
        if(getByRendszam(gepjarmu.getRendszam()) != null){
            return true;
        }else{
            return false;
        }
    }

    /*
    public List<Gepjarmu> getByTulajdonosId(Integer id){
        Query query = this.em.createQuery("select g from Gepjarmu where g.tulajdonos = id").setParameter("id", id);
        return query.getResultList();
    }*/

}

