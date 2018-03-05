package crm.app.services.user.usermanagement;


import crm.app.data.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserManagementService {

    List<AppUser> getAll();

    void changePassword(ChangePasswordDTO changePasswordDTO) throws Exception;

}
