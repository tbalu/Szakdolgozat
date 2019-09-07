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


    public void remove(T entity) {
        this.entityManager.getTransaction().begin();
        entityManager.remove(entity);
        this.entityManager.getTransaction().commit();
    }


    public void update(T entity) {
        this.entityManager.getTransaction().begin();
        entityManager.merge(entity);
        this.entityManager.getTransaction().commit();
    }

    public T getById(Object id){

        return this.entityManager.find(entityClass,id);

    }
}
