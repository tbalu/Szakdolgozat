package daos;

import com.google.inject.persist.Transactional;
import entities.Tulajdonos;

import javax.persistence.EntityManager;

public abstract class BasicDao<T> {

    protected Class<T> entityClass;
    protected EntityManager entityManager;

    public BasicDao(Class<T> entityClass){
        this.entityClass = entityClass;
    }


    public void persist(T entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Transactional
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Transactional
    public void update(T entity) {
        entityManager.merge(entity);
    }

}
