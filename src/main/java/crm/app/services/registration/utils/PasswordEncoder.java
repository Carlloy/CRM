package crm.app.services.registration.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
