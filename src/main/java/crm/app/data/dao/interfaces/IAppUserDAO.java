package crm.app.data.dao.interfaces;

import crm.app.data.dao.abstraction.IDAO;
import crm.app.data.model.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserDAO extends IDAO<AppUser> {

    Boolean isEmailExists(String email);

    AppUser findByEmail(String email);


}
