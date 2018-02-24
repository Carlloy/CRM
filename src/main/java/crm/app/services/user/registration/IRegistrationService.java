package crm.app.services.user.registration;

import crm.app.services.user.exception.InvalidCredentialsException;

public interface IRegistrationService {

    void registration(RegistrationUserDTO userDTO) throws InvalidCredentialsException;
}
