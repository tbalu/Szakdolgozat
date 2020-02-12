package daos;

import entities.Gepjarmuparameter;

import javax.persistence.EntityManager;

public class GepjarmuparameterDao extends BasicDao<Gepjarmuparameter>{
    public GepjarmuparameterDao(EntityManager em) {
        super(Gepjarmuparameter.class);
        this.em = em;
    }

    //public void saveOrUp
}
