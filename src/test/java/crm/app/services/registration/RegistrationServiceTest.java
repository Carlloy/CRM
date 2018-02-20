package crm.app.services.registration;

import crm.app.data.dao.AppUserDAO;
import crm.app.services.registration.exception.InvalidCredentialsException;
import crm.app.services.registration.exception.InvalidEmailException;
import crm.app.services.registration.utils.PasswordEncoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RegistrationService.class, AppUserDAO.class, PasswordEncoder.class})
public class RegistrationServiceTest {

    @Autowired
    RegistrationService registrationService;

    @Test(expected = InvalidEmailException.class)
    public void isExcepionRiseWhenEmailIsWrong() throws InvalidCredentialsException {
        UserDTO userDTO = new UserDTO("Adam", "Nowak", "adam.nowak@onet.pl","Hasło12","Hasło12");
        registrationService.registration(userDTO);
    }
}
