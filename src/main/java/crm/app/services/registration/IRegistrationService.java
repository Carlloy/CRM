package crm.app.services.registration;

import crm.app.services.registration.exception.InvalidCredentialsException;
import crm.app.services.registration.transfer.UserDTO;

public interface IRegistrationService {

    void registration(UserDTO userDTO) throws InvalidCredentialsException;
}
