package crm.app.services.user.usermanagement;

import crm.app.configuration.security.PasswordEncoderConfig;
import crm.app.data.dao.interfaces.AppUserDAO;
import crm.app.data.model.AppUser;
import crm.app.services.user.exception.InvalidPasswordException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserManagementServiceImpl.class, AppUserDAO.class, PasswordEncoderConfig.class})
public class UserManagementServiceImplTest {

    @Autowired
    UserManagementService userManagementService;

    @MockBean
    AppUserDAO appUserDAO;

    @Before
    public void setUp() {
        AppUser appUser = new AppUser();
        appUser.setPassword("$2a$10$Z1KmuQrA2/S5NExkbl0bteIv1WSuse8Qpy/RuoxtDw4L8s0KV7SXq");
        MockitoAnnotations.initMocks(this);
        Mockito.when(appUserDAO.findByEmail(Matchers.any(String.class))).thenReturn(appUser);
    }

    @Test(expected = InvalidPasswordException.class)
    public void ifNewPasswordsAreNotEqualsRaiseException() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO("", "", "Password123", "Pass1456");
        userManagementService.changePassword(changePasswordDTO);
    }

    @Test
    public void ifNewPasswordsAreEqualReturnTrue() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO("", "Password123", "Password123", "Password123");
        userManagementService.changePassword(changePasswordDTO);
    }

    @Test(expected = InvalidPasswordException.class)
    public void ifOldPasswordIsWrongRaiseException() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO("", "$2a$10$9pJNjyj/800iO5CC8U6SHu8zHvhe1jvwX0rn4p973394geOQ26UKR", "Password123", "Password123");
        userManagementService.changePassword(changePasswordDTO);
    }
}