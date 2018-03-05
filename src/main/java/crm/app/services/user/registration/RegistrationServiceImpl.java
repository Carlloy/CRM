package crm.app.services.user.registration;

import crm.app.data.dao.interfaces.AppUserDAO;
import crm.app.data.model.AppUser;
import crm.app.services.user.exception.InvalidCredentialsException;
import crm.app.services.user.utils.EmailValidator;
import crm.app.services.user.utils.PasswordValidator;
import crm.app.services.user.utils.ValueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final AppUserDAO appUserDAO;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServiceImpl(AppUserDAO appUserDAO, PasswordEncoder passwordEncoder) {
        this.appUserDAO = appUserDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registration(RegistrationUserDTO userDTO) throws InvalidCredentialsException {
        AppUser appUser = new AppUser();
        EmailValidator.isEmailCorrect(userDTO.getEmail());
        EmailValidator.isEmailUsed(appUserDAO, userDTO.getEmail());
        PasswordValidator.isPasswordValid(userDTO.getPassword());
        PasswordValidator.isPasswordConfirmed(userDTO.getPassword(), userDTO.getConfirmPassword());
        ValueValidator.isValue("user name", userDTO.getName());
        ValueValidator.isValue("user surname", userDTO.getSurname());
        appUser.setName(userDTO.getName());
        appUser.setSurname(userDTO.getSurname());
        appUser.setEmail(userDTO.getEmail());
        appUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        appUserDAO.create(appUser);
    }


}
