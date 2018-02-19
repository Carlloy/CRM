package crm.app.data.dao.abstraction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public abstract class HibernateSession<T extends Serializable> {

    protected SessionFactory sessionFactory;
    protected Class<T> entityClass;
    protected Session session = null;
    protected Transaction transaction = null;

    public HibernateSession(Class<T> entityClass) {
        this.entityClass = entityClass;
        sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").buildSessionFactory();
    }

    protected Session openSession() {
        return sessionFactory.openSession();
    }

    protected void beginTransaction() {
        session = openSession();
        transaction = session.getTransaction();
        transaction.begin();
    }

    protected void transactionCommit() {
        transaction.commit();
    }

    protected void transactionRollback() {
        if (transaction != null)
            transaction.rollback();
    }

    protected void sessionClose() {
        if (session != null)
            session.close();
    }

    protected Session getSession() {
        return this.session;
    }

}
