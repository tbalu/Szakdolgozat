package jpa;

import com.google.inject.persist.Transactional;
import org.hibernate.exception.ConstraintViolationException;
import org.pmw.tinylog.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public abstract class GenericJpaDao<T> {

    protected Class<T> entityClass;
    protected EntityManager entityManager;
    private Exception e;

    public GenericJpaDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Inject
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(rollbackOn = {Exception.class})
    public void persist(T entity){
        entityManager.persist(entity);
    }

    public void persistUj(T entity) {
        try{
        //em.persist(entity);
        persistSeged(entity);
        }catch (RollbackException c){
            System.out.println("Már van ilyen kulcsú objektum");
        }
    }


    private void persistSeged(T entity) throws RollbackException {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Transactional
    public Optional<T> find(Object primaryKey) {
        Logger.info("Find fuggveny");
        return Optional.ofNullable(entityManager.find(entityClass, primaryKey));
    }

    @Transactional
    public List<T> findAll() {
        TypedQuery<T> typedQuery = entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass);
        return typedQuery.getResultList();
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
