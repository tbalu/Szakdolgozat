package daos;

import entities.Alkatresz;

import javax.persistence.EntityManager;

public class AlkatreszDao extends BasicDao<Alkatresz> {

    public AlkatreszDao(EntityManager em) {
        super(Alkatresz.class);
        this.em = em;
    }

}
