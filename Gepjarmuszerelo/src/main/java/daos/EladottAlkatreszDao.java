package daos;

import entities.EladottAlkatresz;

import javax.persistence.EntityManager;


public class EladottAlkatreszDao extends BasicDao<EladottAlkatresz> {
    public EladottAlkatreszDao(EntityManager em) {
        super(EladottAlkatresz.class);
        this.em = em;
    }
}
