package crm.app.services.user.usermanagement;


import crm.app.data.model.AppUser;
import crm.app.services.user.usermanagement.dto.UserDetailsDTO;
import crm.app.services.user.usermanagement.dto.UserPasswordDTO;

import java.util.List;


public interface UserManagementService {

    List<AppUser> getAll();

    void changePassword(UserPasswordDTO userPasswordDTO) throws Exception;

    void changeUserDetails(UserDetailsDTO userDetailsDTO) throws Exception;
}
