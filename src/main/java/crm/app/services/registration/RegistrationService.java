package crm.app.services.registration;

import crm.app.data.dao.AppUserDAO;
import crm.app.data.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements IRegistrationService{

    @Autowired
    private AppUserDAO appUserDAO;


    @Override
    public boolean registration(AppUser appUser) {

        return false;
    }
    
}
