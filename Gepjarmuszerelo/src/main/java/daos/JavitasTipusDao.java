package daos;

import entities.OradijasJavitasTipus;

import javax.persistence.EntityManager;

public class JavitasTipusDao extends BasicDao<OradijasJavitasTipus> {
    public JavitasTipusDao(EntityManager em) {
        super(OradijasJavitasTipus.class);
        this.em = em;
    }
}
