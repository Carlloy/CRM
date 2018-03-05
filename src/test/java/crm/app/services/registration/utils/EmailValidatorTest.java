package crm.app.services.registration.utils;

import crm.app.data.dao.interfaces.AppUserDAO;
import crm.app.services.user.exception.InvalidEmailException;
import crm.app.services.user.registration.RegistrationUserDTO;
import crm.app.services.user.utils.EmailValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmailValidatorTest {

    @Mock
    private AppUserDAO appUserDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(appUserDAO.isEmailExists("email.exists.in.db@gmail.com")).thenReturn(true);
        when(appUserDAO.isEmailExists("email.not.exists.in.db@gmail.com")).thenReturn(false);
    }


    @Test(expected = InvalidEmailException.class)
    public void if_email_exists_in_db_raise_exception() throws InvalidEmailException {
        EmailValidator.isEmailUsed(appUserDAO, new RegistrationUserDTO.UserDTOBuilder().withEmail("email.exists.in.db@gmail.com").build().getEmail());
    }

    @Test
    public void if_email_not_exists_in_db_method_should_pass() throws InvalidEmailException {
        EmailValidator.isEmailUsed(appUserDAO, new RegistrationUserDTO.UserDTOBuilder().withEmail("email.not.exists.in.db@gmail.com").build().getEmail());
    }


    @Test(expected = InvalidEmailException.class)
    public void if_format_of_email_is_incorrect_raise_exception() throws InvalidEmailException {
        EmailValidator.isEmailCorrect(new RegistrationUserDTO.UserDTOBuilder().withEmail("email.gmail.com").build().getEmail());
    }

    @Test
    public void if_format_of_email_is_correct_should_pass() throws InvalidEmailException {
        EmailValidator.isEmailCorrect(new RegistrationUserDTO.UserDTOBuilder().withEmail("email@gmail.com").build().getEmail());
    }


}