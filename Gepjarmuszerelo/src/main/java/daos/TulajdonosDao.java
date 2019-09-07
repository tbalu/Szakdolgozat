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
import java.util.stream.Collectors;

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
                .where(qTulajdonos.jogositvanyszam.eq(jogositvanyszam))
                .fetchFirst();
    return tnev;
    }

    public List<Tulajdonos> getAll(){

        Query query = this.entityManager.createQuery("from Tulajdonos T");
        return query.getResultList();

    }

    public List<String> getAllJogositvanyszam(){

        return this.getAll().stream().map(Tulajdonos::getJogositvanyszam).collect(Collectors.toList());

    }

    /* TODO  teszt*/

    //public List<>

}
