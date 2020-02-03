package daos;

import entities.OsAlkatresz;

import javax.persistence.EntityManager;

public  class AlkatreszDao extends BasicDao<OsAlkatresz> {

    public AlkatreszDao(EntityManager em) {
        super(OsAlkatresz.class);
        this.em = em;
    }

}
