package daos;

import com.google.inject.persist.Transactional;
import com.querydsl.jpa.impl.JPAQueryFactory;
import entities.*;
import entities.QGepjarmu;
import jpa.GenericJpaDao;

import javax.persistence.EntityManager;

public class GepjarmuDao extends BasicDao<Gepjarmu> {

    public GepjarmuDao(EntityManager entityManager){
        super(Gepjarmu.class);
        this.entityManager = entityManager;
    }
    @Transactional
    public void addSzerelesekhez(Gepjarmu g, Szereles sz){
        g.getSzerelesek().add(sz);
    }

    Gepjarmu getByRendszam(String rendszam){
        JPAQueryFactory queryFactory = new JPAQueryFactory(this.entityManager);
        QGepjarmu qGepjarmu = QGepjarmu.gepjarmu;
        Gepjarmu gnev = queryFactory.selectFrom(qGepjarmu)
                .where(qGepjarmu.Rendszam.eq(rendszam))
                .fetchFirst();
        return gnev;
    }

}

