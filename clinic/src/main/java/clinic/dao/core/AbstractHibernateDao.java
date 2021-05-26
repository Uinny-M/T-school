package clinic.dao.core;


import clinic.dao.api.AbstractDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractHibernateDao<T> implements AbstractDao<T> {
    private final Class<T> clazz;

    @PersistenceContext
    protected EntityManager em;

    public AbstractHibernateDao(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }


    @Override
    public T findById(Number id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("from " + clazz.getName(), clazz)
                .getResultList();
    }

    @Override
    public T save(T entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Override
    public void deleteById(Number entityId) {
        T entity = findById(entityId);
        delete(entity);
    }
}
