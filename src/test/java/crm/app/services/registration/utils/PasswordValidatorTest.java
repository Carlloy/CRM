package crm.app.services.registration.utils;

import crm.app.services.registration.exception.InvalidPasswordException;
import crm.app.services.registration.transfer.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class PasswordValidatorTest {


    @Test(expected = InvalidPasswordException.class)
    public void when_password_is_incorrect() throws InvalidPasswordException {
        PasswordValidator.isPasswordValid(new UserDTO.UserDTOBuilder().withPassword("Hasłobezliczb").build());
    }

    @Test
    public void when_password_is_correct() throws InvalidPasswordException {
        PasswordValidator.isPasswordValid(new UserDTO.UserDTOBuilder().withPassword("Hasło1234").build());
    }

    @Test(expected = InvalidPasswordException.class)
    public void when_passwords_are_not_equel() throws InvalidPasswordException {
        PasswordValidator.isPasswordConfirmed(new UserDTO.UserDTOBuilder().withPassword("Hasło123").withConfirmPassword("InneHasło123").build());
    }

    @Test
    public void when_passwords_are_equel() throws InvalidPasswordException {
        PasswordValidator.isPasswordConfirmed(new UserDTO.UserDTOBuilder().withPassword("Hasło123").withConfirmPassword("Hasło123").build());
    }

}
