package daos;

import entities.Szerelo;

import javax.persistence.EntityManager;

public class SzereloDao extends BasicDao<Szerelo> {
    public SzereloDao(EntityManager em) {

        super(Szerelo.class);
        this.em = em;
    }
}
