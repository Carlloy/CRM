package crm.app.services.security;

import crm.app.data.dao.interfaces.AppUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    AppUserDAO appUserDAO;

    @Override
    public UserDetails loadUserByUsername(String email) {
        AuthUserDetails user = new AuthUserDetails(appUserDAO.findByEmail(email));
        User.withDefaultPasswordEncoder().username(user.getUsername()).password(user.getPassword()).authorities(user.getAuthorities()).build();
        return user;
    }
}
