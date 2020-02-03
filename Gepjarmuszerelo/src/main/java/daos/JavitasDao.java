package daos;

import entities.OsJavitas;

import javax.persistence.EntityManager;

public class JavitasDao extends BasicDao<OsJavitas> {
    public JavitasDao(EntityManager em) {
        super(OsJavitas.class);
        this.em = em;
    }
}
