package crm.app.controller.user.registration;

import crm.app.data.model.AppUser;
import crm.app.services.user.IUserService;
import crm.app.services.user.exception.InvalidCredentialsException;
import crm.app.services.user.registration.IRegistrationService;
import crm.app.services.user.registration.RegistrationUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegistrationController {

    private final IRegistrationService registrationService;

    private final IUserService userService;

    @Autowired
    public RegistrationController(IRegistrationService registrationService, IUserService userService) {
        this.registrationService = registrationService;
        this.userService = userService;
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody RegistrationUserDTO userDTO) throws InvalidCredentialsException {
        registrationService.registration(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<AppUser> getUsers(@RequestBody RegistrationUserDTO userDTO) throws InvalidCredentialsException {
        return userService.getAll();
    }


}
