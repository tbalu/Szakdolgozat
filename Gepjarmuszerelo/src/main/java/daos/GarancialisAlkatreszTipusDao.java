package daos;


import entities.GarancialisAlkatreszTipus;

import javax.persistence.EntityManager;

public class GarancialisAlkatreszTipusDao extends BasicDao<GarancialisAlkatreszTipus> {

    public GarancialisAlkatreszTipusDao(EntityManager em){
        super(GarancialisAlkatreszTipus.class);
        this.em = em;

    }

}
