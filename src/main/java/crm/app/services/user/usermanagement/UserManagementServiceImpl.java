package crm.app.services.user.usermanagement;

import crm.app.data.dao.interfaces.AppUserDAO;
import crm.app.data.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final AppUserDAO appUserDAO;

    @Autowired
    public UserManagementServiceImpl(AppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;
    }


    @Override
    public List<AppUser> getAll() {
        return appUserDAO.findAll();
    }
}
