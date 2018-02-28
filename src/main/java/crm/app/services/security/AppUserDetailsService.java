package crm.app.services.security;

import crm.app.data.dao.AppUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    AppUserDAO appUserDAO;

    @Override
    public UserDetails loadUserByUsername(String email) {
        AuthUserDetails user = new AuthUserDetails(appUserDAO.findByEmail(email));

        User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();
        if (user == null) throw new UsernameNotFoundException("Email not found.");
        return user;
    }
}
