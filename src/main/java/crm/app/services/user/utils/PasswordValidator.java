package crm.app.services.user.utils;

import crm.app.services.user.exception.InvalidPasswordException;

public class PasswordValidator {

    private PasswordValidator() {
    }

    public static void isPasswordConfirmed(String password, String confirmedPassword) throws InvalidPasswordException {
        if (!(password.equals(confirmedPassword))) {
            throw new InvalidPasswordException("Passwords are not similar");
        }
    }

    public static void isPasswordValid(String password) throws InvalidPasswordException {
        if (!(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$"))) {
            throw new InvalidPasswordException("Password should include at least one upper, lower letter and a number");
        }
    }
}
