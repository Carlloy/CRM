package crm.app.services.registration;

import crm.app.configuration.PasswordEncoderConfig;
import crm.app.data.dao.AppUserDAO;
import crm.app.services.user.exception.InvalidCredentialsException;
import crm.app.services.user.registration.RegistrationService;
import crm.app.services.user.registration.RegistrationUserDTO;
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
@ContextConfiguration(classes = {RegistrationService.class, AppUserDAO.class, PasswordEncoderConfig.class})
public class RegistrationServiceTest {

    @Autowired
    RegistrationService registrationService;

    @MockBean
    AppUserDAO appUserDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(appUserDAO.isEmailExists(Matchers.any(String.class))).thenReturn(false);
    }

    @Test
    public void when_fields_are_ok_dto_should_be_saved() throws InvalidCredentialsException {
        RegistrationUserDTO userDTO = new RegistrationUserDTO("Andrzej", "Krul", "andrzej.krul@gmail.com", "Password123", "Password123");

        registrationService.registration(userDTO);
    }

}
