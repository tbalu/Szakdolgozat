package daos;

import com.querydsl.jpa.impl.JPAQueryFactory;
import entities.QGepjarmu;
import entities.QSzereles;
import entities.Szereles;

import javax.persistence.EntityManager;
import java.util.List;

public class SzerelesDao extends BasicDao<Szereles> {

        SzerelesDao(EntityManager em){
            super(Szereles.class);
            this.entityManager = em;
        }

        public List<Szereles> befejezetlenSzerelesek(){
            JPAQueryFactory queryFactory = new JPAQueryFactory(this.entityManager);
            QSzereles qSzereles = QSzereles.szereles;
            return queryFactory.selectFrom(qSzereles).where(qSzereles.szerelesVege.isNull()).fetch();
    }
}
