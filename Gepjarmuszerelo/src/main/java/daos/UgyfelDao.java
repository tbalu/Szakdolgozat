package daos;

import entities.Ugyfel;

import javax.persistence.EntityManager;

public class UgyfelDao extends BasicDao<Ugyfel> {
    public UgyfelDao(EntityManager em) {
        super(Ugyfel.class);
        this.em = em;
    }
}
