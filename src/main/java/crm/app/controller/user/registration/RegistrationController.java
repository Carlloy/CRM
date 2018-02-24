package crm.app.controller.user.registration;

import crm.app.services.user.registration.IRegistrationService;
import crm.app.services.user.registration.RegistrationUserDTO;
import crm.app.services.user.registration.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final IRegistrationService registrationService;

    @Autowired
    public RegistrationController(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody RegistrationUserDTO userDTO) throws InvalidCredentialsException {
        registrationService.registration(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
