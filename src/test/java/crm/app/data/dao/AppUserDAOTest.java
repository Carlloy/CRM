package crm.app.data.dao;

import org.junit.Assert;
import org.junit.Test;

public class AppUserDAOTest {

    @Test
    public void isEmailExists() {
        AppUserDAO appUserDAO = new AppUserDAO();
        Boolean result = appUserDAO.isEmailExists("admin@gmail.com");
        Assert.assertTrue(result);
    }
}