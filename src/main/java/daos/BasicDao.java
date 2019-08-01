package daos;

import entities.Tulajdonos;

import javax.persistence.EntityManager;

public abstract class BasicDao<T> {
    private EntityManager em;
    private Class<T> entityClass;

    private Class t = Tulajdonos.class;
    BasicDao(){

    }
}
