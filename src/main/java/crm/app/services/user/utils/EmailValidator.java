package crm.app.services.user.utils;

import crm.app.data.dao.interfaces.AppUserDAO;
import crm.app.services.user.exception.InvalidEmailException;
import crm.app.services.user.registration.RegistrationUserDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@+[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

    private EmailValidator() {
    }

    private static boolean validate(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void isEmailUsed(AppUserDAO appUserDAO, RegistrationUserDTO userDTO) throws InvalidEmailException {
        if (appUserDAO.isEmailExists(userDTO.getEmail())) {
            throw new InvalidEmailException("Email is already used");
        }
    }

    public static void isEmailCorrect(RegistrationUserDTO userDTO) throws InvalidEmailException {
        if (!EmailValidator.validate(userDTO.getEmail())) {
            throw new InvalidEmailException("Email is incorrect");
        }
    }
}
