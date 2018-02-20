package crm.app.services.registration;
import crm.app.services.registration.utils.EmailValidator;
import org.springframework.util.StringUtils;
import crm.app.data.dao.AppUserDAO;
import crm.app.data.model.AppUser;
import crm.app.services.registration.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements IRegistrationService{

    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registration(UserDTO userDTO) throws InvalidCredentialsException{
    AppUser appUser = new AppUser();
    isEmailCorrect(userDTO);
    isPasswordValid(userDTO);
    isValue(userDTO.getName());
    isValue(userDTO.getSurname());
    appUser.setName(userDTO.getName());
    appUser.setSurname(userDTO.getSurname());
    appUser.setEmail(userDTO.getEmail());
    appUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    appUserDAO.create(appUser);
    }

    private boolean isEmailCorrect(UserDTO userDTO) throws InvalidCredentialsException{
        if(EmailValidator.validate(userDTO.getEmail())){
            return true;
        }
       throw new InvalidCredentialsException();
    }
    private boolean isPasswordConfirmed(UserDTO userDTO) throws InvalidCredentialsException {
        if(userDTO.getPassword().equals(userDTO.getConfirmPassword())){
            return true;
        }
        throw new InvalidCredentialsException();
    }

    private boolean isPasswordValid(UserDTO userDTO) throws InvalidCredentialsException{
        isPasswordConfirmed(userDTO);
        if(userDTO.getPassword().length()>=6 && userDTO.getPassword().matches(" [a-z]+")&&
                userDTO.getPassword().matches(" [A-Z]+")&& userDTO.getPassword().matches(" [0-9]+")){
            return true;
        }
        throw new InvalidCredentialsException();
    }

    private boolean isValue(String value) throws InvalidCredentialsException{
        if(!StringUtils.isEmpty(value)){
            return true;
        }
        throw new InvalidCredentialsException();
    }

}
