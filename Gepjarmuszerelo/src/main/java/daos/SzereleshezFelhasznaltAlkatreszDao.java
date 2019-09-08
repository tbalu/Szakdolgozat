package daos;

import com.querydsl.jpa.impl.JPAQueryFactory;
import entities.QSzereleshezHasznaltAlkatresz;
import entities.SzereleshezHasznaltAlkatresz;

import javax.persistence.EntityManager;
import java.util.List;

public class SzereleshezFelhasznaltAlkatreszDao extends BasicDao<SzereleshezHasznaltAlkatresz> {

    public SzereleshezFelhasznaltAlkatreszDao(EntityManager em){
        super(SzereleshezHasznaltAlkatresz.class);
        this.em = em;
    }
/*
    public SzereleshezHasznaltAlkatresz update(SzereleshezHasznaltAlkatresz szereleshezHasznaltAlkatresz){
        return null;
    }*/

    public boolean isLetezik(SzereleshezHasznaltAlkatresz szereleshezHasznaltAlkatresz){
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(this.em);
        QSzereleshezHasznaltAlkatresz qSzereleshezHasznaltAlkatresz = QSzereleshezHasznaltAlkatresz.szereleshezHasznaltAlkatresz;
        List<SzereleshezHasznaltAlkatresz> res = jpaQueryFactory.selectFrom(qSzereleshezHasznaltAlkatresz).
                where(qSzereleshezHasznaltAlkatresz.szereles.eq(szereleshezHasznaltAlkatresz.getSzereles()).and(
                        qSzereleshezHasznaltAlkatresz.alkatresz.eq(szereleshezHasznaltAlkatresz.getAlkatresz())
                )).fetch();
        return !res.isEmpty();
    }
}
