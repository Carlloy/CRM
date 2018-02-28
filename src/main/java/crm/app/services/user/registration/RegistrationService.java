package crm.app.services.user.registration;

import crm.app.services.user.exception.InvalidCredentialsException;

public interface RegistrationService {

    void registration(RegistrationUserDTO userDTO) throws InvalidCredentialsException;
}
