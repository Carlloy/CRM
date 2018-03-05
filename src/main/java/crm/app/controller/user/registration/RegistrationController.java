package crm.app.controller.user.registration;

import crm.app.data.model.AppUser;
import crm.app.services.user.exception.InvalidCredentialsException;
import crm.app.services.user.registration.RegistrationService;
import crm.app.services.user.registration.RegistrationUserDTO;
import crm.app.services.user.usermanagement.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/")
@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    private final UserManagementService userService;

    @Autowired
    public RegistrationController(RegistrationService registrationService, UserManagementService userService) {
        this.registrationService = registrationService;
        this.userService = userService;
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody RegistrationUserDTO userDTO) throws InvalidCredentialsException {
        registrationService.registration(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
/*
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "HI";
    }*/

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<AppUser> getUsers() throws InvalidCredentialsException {
        return userService.getAll();
    }


}
