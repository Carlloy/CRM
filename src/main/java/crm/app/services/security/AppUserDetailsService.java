package crm.app.services.security;

import crm.app.data.dao.interfaces.AppUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    AppUserDAO appUserDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) {
        AuthUserDetails user = new AuthUserDetails(appUserDAO.findByEmail(email));
        return User.withDefaultPasswordEncoder().username(user.getUsername()).password(user.getPassword()).authorities(user.getAuthorities()).build();
    }
}
