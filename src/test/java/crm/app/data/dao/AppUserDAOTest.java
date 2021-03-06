package crm.app.data.dao;

import crm.app.configuration.db.HibernateConfig;
import crm.app.data.dao.implementations.AppUserDAOImpl;
import crm.app.data.dao.interfaces.AppUserDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppUserDAOImpl.class, HibernateConfig.class})
public class AppUserDAOTest {

    @Autowired
    AppUserDAO appUserDAO;

    @Test
    public void isEmailExists() {
        Boolean result = appUserDAO.isEmailExists("admin@gmail.com");
        Assert.assertTrue(result);
    }
}