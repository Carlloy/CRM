package crm.app.data.dao.abstraction;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDAO<T extends Serializable> extends HibernateSession<T> implements IDAO<T> {

    public AbstractDAO(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public T findById(Long id) {
        T entity = null;
        try {
            beginTransaction();
            entity = getSession().get(entityClass, id);
        } finally {
            sessionClose();
        }
        return entity;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        List<T> entities = null;
        try {
            beginTransaction();
            entities = getSession().createQuery("From " + entityClass.getName()).getResultList();
        } finally {
            sessionClose();
        }
        return entities;
    }

    @Override
    public void create(T object) {
        try {
            beginTransaction();
            getSession().save(object);
            transactionCommit();
        } catch (Exception e) {
            transactionRollback();
        } finally {
            sessionClose();
        }
    }

    @Override
    public void update(T object) {
        try {
            beginTransaction();
            getSession().update(object);
            transactionCommit();
        } catch (Exception e) {
            transactionRollback();
        } finally {
            sessionClose();
        }
    }

    @Override
    public void createOrUpdate(T object) {
        try {
            beginTransaction();
            getSession().saveOrUpdate(object);
            transactionCommit();
        } catch (Exception e) {
            transactionRollback();
        } finally {
            sessionClose();
        }
    }

    @Override
    public void delete(T object) {
        try {
            beginTransaction();
            getSession().delete(object);
            transactionCommit();
        } catch (Exception e) {
            transactionRollback();
        } finally {
            sessionClose();
        }
    }

    @Override
    public void deleteById(Long id) {
        T object = findById(id);
        delete(object);
    }

}
