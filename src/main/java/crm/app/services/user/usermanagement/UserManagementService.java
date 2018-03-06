package crm.app.services.user.usermanagement;


import crm.app.data.model.AppUser;
import crm.app.services.user.usermanagement.dto.ChangePasswordDTO;

import java.util.List;


public interface UserManagementService {

    List<AppUser> getAll();

    void changePassword(ChangePasswordDTO changePasswordDTO) throws Exception;

}
