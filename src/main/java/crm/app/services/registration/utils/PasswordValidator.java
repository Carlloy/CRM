package crm.app.services.registration.utils;

import crm.app.services.registration.UserDTO;
import crm.app.services.registration.exception.InvalidPasswordException;

public class PasswordValidator {

    public static void isPasswordConfirmed(UserDTO userDTO) throws InvalidPasswordException {
        if(!(userDTO.getPassword().equals(userDTO.getConfirmPassword()))){
            throw new InvalidPasswordException("Passwords are not similar");
        }
    }

    public static void isPasswordValid(UserDTO userDTO) throws InvalidPasswordException{
        if(!(userDTO.getPassword().length()>=6 && userDTO.getPassword().matches(" [a-z]+")&&
                userDTO.getPassword().matches(" [A-Z]+")&& userDTO.getPassword().matches(" [0-9]+"))){
            throw new InvalidPasswordException("Password should include at least one upper, lower letter and a number");
        }

    }
}
