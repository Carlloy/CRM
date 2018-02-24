package crm.app.services.user.registration;

import crm.app.data.dao.AppUserDAO;
import crm.app.data.model.AppUser;
import crm.app.services.user.registration.exception.InvalidCredentialsException;
import crm.app.services.user.registration.utils.EmailValidator;
import crm.app.services.user.registration.utils.PasswordEncoder;
import crm.app.services.user.registration.utils.PasswordValidator;
import crm.app.services.user.registration.utils.ValueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements IRegistrationService {

    private final AppUserDAO appUserDAO;

    @Autowired
    public RegistrationService(AppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;
    }

    @Override
    public void registration(RegistrationUserDTO userDTO) throws InvalidCredentialsException {
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
