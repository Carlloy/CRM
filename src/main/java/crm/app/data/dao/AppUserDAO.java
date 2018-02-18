package crm.app.data.dao;

import crm.app.data.dao.abstraction.AbstractDAO;
import crm.app.data.model.AppUser;

public class AppUserDAO extends AbstractDAO<AppUser> {

    public AppUserDAO(Class entityClass) {
        super(AppUser.class);
    }
}
