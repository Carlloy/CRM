package crm.app.services.security;

import crm.app.data.dao.interfaces.AppUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsServiceImpl implements AppUserDetailsService {

    private final AppUserDAO appUserDAO;

    @Autowired
    public AppUserDetailsServiceImpl(AppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        AuthUserDetails user = new AuthUserDetails(appUserDAO.findByEmail(email));
        return User.withUsername(user.getUsername()).password("{bcrypt}" + user.getPassword()).authorities(user.getAuthorities()).build();
    }

}
