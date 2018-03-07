package crm.app.services.user.usermanagement;

import crm.app.data.dao.interfaces.AppUserDAO;
import crm.app.data.model.AppUser;
import crm.app.services.user.exception.InvalidPasswordException;
import crm.app.services.user.usermanagement.dto.UserDetailsDTO;
import crm.app.services.user.usermanagement.dto.UserPasswordDTO;
import crm.app.services.user.utils.PasswordValidator;
import crm.app.services.user.utils.ValueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final AppUserDAO appUserDAO;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserManagementServiceImpl(AppUserDAO appUserDAO, PasswordEncoder passwordEncoder) {
        this.appUserDAO = appUserDAO;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<AppUser> getAll() {
        return appUserDAO.findAll();
    }

    @Override
    public void changePassword(UserPasswordDTO userPasswordDTO) throws Exception {
        PasswordValidator.isPasswordValid(userPasswordDTO.getNewPassword());
        PasswordValidator.isPasswordConfirmed(userPasswordDTO.getNewPassword(), userPasswordDTO.getConfirmPassword());

        AppUser appUser = appUserDAO.findByEmail(userPasswordDTO.getEmail());
        if (appUser == null) {
            throw new UsernameNotFoundException("Email " + userPasswordDTO.getEmail() + " does not exist");
        }
        if (!passwordEncoder.matches(userPasswordDTO.getOldPassword(), appUser.getPassword())) {
            throw new InvalidPasswordException("Wrong password");
        }
        appUser.setPassword(passwordEncoder.encode(userPasswordDTO.getNewPassword()));
        appUserDAO.update(appUser);
    }

    @Override
    public void changeUserDetails(UserDetailsDTO userDetailsDTO) throws Exception {
        AppUser appUser = appUserDAO.findByEmail(userDetailsDTO.getEmail());
        if (appUser == null) {
            throw new UsernameNotFoundException("Email " + userDetailsDTO.getEmail() + " does not exist");
        }
        ValueValidator.isValue("name", userDetailsDTO.getName());
        ValueValidator.isValue("surname", userDetailsDTO.getSurname());
        appUser.setName(userDetailsDTO.getName());
        appUser.setSurname(userDetailsDTO.getSurname());
        appUserDAO.update(appUser);
    }
}
