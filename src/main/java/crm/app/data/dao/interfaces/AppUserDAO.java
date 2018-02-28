package crm.app.data.dao.interfaces;

import crm.app.data.dao.abstraction.IDAO;
import crm.app.data.model.AppUser;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AppUserDAO extends IDAO<AppUser> {

    Boolean isEmailExists(String email);

    AppUser findByEmail(String email);


}
