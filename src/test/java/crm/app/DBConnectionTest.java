package crm.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

public class DBConnectionTest {
    @Test
    public void connection_test() {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(String.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Assert.assertNotNull(sessionFactory);
        Assert.assertNotNull(session);
        sessionFactory.close();
    }
}
