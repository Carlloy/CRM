package crm.app.data.dao.abstraction;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDAO<T extends Serializable> implements IDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(Long id) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }


    @Override
    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void create(T object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void update(T object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void createOrUpdate(T object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    @Override
    public void delete(T object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public void deleteById(Long id) {
        T object = findById(id);
        delete(object);
    }

}
