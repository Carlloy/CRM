package crm.app.services.registration.utils;

import crm.app.services.registration.exception.InvalidPasswordException;
import crm.app.services.registration.transfer.UserDTO;

public class PasswordValidator {

    public static void isPasswordConfirmed(UserDTO userDTO) throws InvalidPasswordException {
        if (!(userDTO.getPassword().equals(userDTO.getConfirmPassword()))) {
            throw new InvalidPasswordException("Passwords are not similar");
        }
    }

    public static void isPasswordValid(UserDTO userDTO) throws InvalidPasswordException {
        if (!(userDTO.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$"))) {
            throw new InvalidPasswordException("Password should include at least one upper, lower letter and a number");
        }

    }
}
