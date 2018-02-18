package crm.app.data.dao.abstraction;

import java.io.Serializable;
import java.util.List;

public class AbstractDAO<T extends Serializable> extends HibernateSession<T> implements IDAO<T>{

    public AbstractDAO(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public T findById(Long id) {
        T entity = null;
        try {
            beginTransaction();
            entity = getSession().get(entityClass, id);
            transactionCommit();
        } catch (Exception e) {
            transactionRollback();
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
            transactionCommit();
        } catch (Exception e) {
            transactionRollback();
        } finally {
            sessionClose();
        }
        return entities;
    }

    @Override
    public void create(T object) {
        beginTransaction();
        try {
            getSession().save(object);
        } catch (Exception e) {
            transactionRollback();
        } finally {
            sessionClose();
        }
    }

    @Override
    public void update(T object) {
        beginTransaction();
        try {
            getSession().update(object);
        } catch (Exception e) {
            transactionRollback();
        } finally {
            sessionClose();
        }
    }

    @Override
    public void createOrUpdate(T object) {
        beginTransaction();
        try {
            getSession().saveOrUpdate(object);
        } catch (Exception e) {
            transactionRollback();
        } finally {
            sessionClose();
        }
    }

    @Override
    public void delete(T object) {
        beginTransaction();
        try {
            getSession().delete(object);
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
