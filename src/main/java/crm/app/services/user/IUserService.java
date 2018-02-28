package crm.app.services.user;


import crm.app.data.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    List<AppUser> getAll();

}
