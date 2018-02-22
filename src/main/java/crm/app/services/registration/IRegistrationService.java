package crm.app.services.registration;

import crm.app.data.model.AppUser;
import crm.app.services.registration.exception.InvalidCredentialsException;

public interface IRegistrationService {

    void registration(UserDTO userDTO) throws InvalidCredentialsException;
}
