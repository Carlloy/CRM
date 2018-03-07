package crm.app.controller.user.usermanagment;

import crm.app.data.model.AppUser;
import crm.app.services.user.usermanagement.UserManagementService;
import crm.app.services.user.usermanagement.dto.UserDetailsDTO;
import crm.app.services.user.usermanagement.dto.UserPasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/api")
public class UserManagmentController {

    final UserManagementService userManagementService;

    @Autowired
    public UserManagmentController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<AppUser> getUsers() {
        return userManagementService.getAll();
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.PUT)
    public ResponseEntity<String> changePassword(@RequestBody UserPasswordDTO userPasswordDTO) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userPasswordDTO.setEmail(authentication.getName());
        userManagementService.changePassword(userPasswordDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @RequestMapping(value = "/changedetails", method = RequestMethod.PUT)
    public ResponseEntity<String> changeDetails(@RequestBody UserDetailsDTO userDetailsDTO) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userDetailsDTO.setEmail(authentication.getName());
        userManagementService.changeUserDetails(userDetailsDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
