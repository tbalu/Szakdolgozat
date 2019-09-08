package daos;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class BasicDao<T> {

    protected Class<T> entityClass;
    protected EntityManager em;

    public BasicDao(Class<T> entityClass){
        this.entityClass = entityClass;
    }


    public void persist(T entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }


    public void remove(T entity) {
        this.em.getTransaction().begin();
        em.remove(entity);
        this.em.getTransaction().commit();
    }


    public void update(T entity) {
        this.em.getTransaction().begin();
        em.merge(entity);
        this.em.getTransaction().commit();
    }

    public T getById(Object id){

        return this.em.find(entityClass,id);

    }

    public List<T> findAll() {
        CriteriaQuery<T> c =
                em.getCriteriaBuilder().createQuery(entityClass);
        c.select(c.from(entityClass));
        return em.createQuery(c).getResultList();
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
