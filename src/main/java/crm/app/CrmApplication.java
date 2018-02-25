package crm.app;

import crm.app.configuration.security.AuthUserDetails;
import crm.app.data.dao.AppUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootApplication
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder, AppUserDAO appUserDAO) throws Exception {
        authenticationManagerBuilder.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) {
                AuthUserDetails user = new AuthUserDetails(appUserDAO.findByEmail(email));
                if (user == null) throw new UsernameNotFoundException("Email not found.");
                return user;
            }
        });
    }
}
