package crm.app.services.registration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    public String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
