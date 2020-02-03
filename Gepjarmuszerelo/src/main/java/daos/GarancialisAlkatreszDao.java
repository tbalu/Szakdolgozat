package daos;

import entities.GarancialisAlkatresz;

import javax.persistence.EntityManager;

public class GarancialisAlkatreszDao extends BasicDao<GarancialisAlkatresz> {


    public GarancialisAlkatreszDao(EntityManager em) {
        super(GarancialisAlkatresz.class);
        this.em = em;
    }


}
