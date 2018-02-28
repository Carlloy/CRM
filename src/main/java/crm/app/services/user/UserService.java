package crm.app.services.user;

import crm.app.data.dao.interfaces.IAppUserDAO;
import crm.app.data.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final IAppUserDAO appUserDAO;

    @Autowired
    public UserService(IAppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;
    }


    @Override
    public List<AppUser> getAll() {
        return appUserDAO.findAll();
    }
}
