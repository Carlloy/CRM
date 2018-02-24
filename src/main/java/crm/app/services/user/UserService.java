package crm.app.services.user;

import crm.app.data.dao.AppUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private AppUserDAO appUserDAO;


}
