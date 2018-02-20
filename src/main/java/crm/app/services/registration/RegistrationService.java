package crm.app.services.registration;

import crm.app.data.dao.AppUserDAO;
import crm.app.data.model.AppUser;
import crm.app.services.registration.exception.InvalidCredentialsException;
import crm.app.services.registration.utils.EmailValidator;
import crm.app.services.registration.utils.PasswordEncoder;
import crm.app.services.registration.utils.PasswordValidator;
import crm.app.services.registration.utils.ValueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements IRegistrationService {

    @Autowired
    private AppUserDAO appUserDAO;

    @Override
    public void registration(UserDTO userDTO) throws InvalidCredentialsException {
        AppUser appUser = new AppUser();
        EmailValidator.isEmailCorrect(userDTO);
        EmailValidator.isEmailUsed(appUserDAO, userDTO);
        PasswordValidator.isPasswordValid(userDTO);
        PasswordValidator.isPasswordConfirmed(userDTO);
        ValueValidator.isValue(userDTO.getName());
        ValueValidator.isValue(userDTO.getSurname());
        appUser.setName(userDTO.getName());
        appUser.setSurname(userDTO.getSurname());
        appUser.setEmail(userDTO.getEmail());
        appUser.setPassword(PasswordEncoder.encode(userDTO.getPassword()));
        appUserDAO.create(appUser);
    }


}
