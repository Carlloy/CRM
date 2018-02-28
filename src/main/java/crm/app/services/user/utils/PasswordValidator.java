package crm.app.services.user.utils;

import crm.app.services.user.exception.InvalidPasswordException;
import crm.app.services.user.registration.RegistrationUserDTO;

public class PasswordValidator {

    private PasswordValidator() {
    }

    public static void isPasswordConfirmed(RegistrationUserDTO userDTO) throws InvalidPasswordException {
        if (!(userDTO.getPassword().equals(userDTO.getConfirmPassword()))) {
            throw new InvalidPasswordException("Passwords are not similar");
        }
    }

    public static void isPasswordValid(RegistrationUserDTO userDTO) throws InvalidPasswordException {
        if (!(userDTO.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$"))) {
            throw new InvalidPasswordException("Password should include at least one upper, lower letter and a number");
        }
    }
}
