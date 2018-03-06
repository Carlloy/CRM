package crm.app.services.user.usermanagement;

import crm.app.data.dao.interfaces.AppUserDAO;
import crm.app.data.model.AppUser;
import crm.app.services.user.exception.InvalidPasswordException;
import crm.app.services.user.usermanagement.dto.ChangePasswordDTO;
import crm.app.services.user.utils.PasswordValidator;
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
    public void changePassword(ChangePasswordDTO changePasswordDTO) throws Exception {
        PasswordValidator.isPasswordValid(changePasswordDTO.getNewPassword());
        PasswordValidator.isPasswordConfirmed(changePasswordDTO.getNewPassword(), changePasswordDTO.getConfirmPassword());

        AppUser appUser = appUserDAO.findByEmail(changePasswordDTO.getEmail());
        if (appUser == null) {
            throw new UsernameNotFoundException("Email " + changePasswordDTO.getEmail() + " does not exist");
        }
        if (!passwordEncoder.matches(changePasswordDTO.getOldPassword(), appUser.getPassword())) {
            throw new InvalidPasswordException("Wrong password");
        }
        appUser.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
        appUserDAO.update(appUser);
    }
}
