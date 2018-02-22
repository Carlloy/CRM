package crm.app.services.registration;

import crm.app.data.model.AppUser;
import crm.app.services.registration.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/registrationUser", method = RequestMethod.POST)
    public ResponseEntity< String > registrationUser(@RequestBody UserDTO userDTO) throws InvalidCredentialsException {
            registrationService.registration(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
