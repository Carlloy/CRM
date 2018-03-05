package crm.app.services.registration.utils;

import crm.app.configuration.security.PasswordEncoderConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PasswordEncoderConfig.class})
public class PasswordEncoderConfigTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void setPasswordEncoderNotNull() {
        Assert.assertNotNull(passwordEncoder);
    }

    @Test
    public void test() {
        String password = "password";
        System.out.println("haslo " + passwordEncoder.encode("secure"));
        Assert.assertTrue(passwordEncoder.matches(password, "$2a$10$9pJNjyj/800iO5CC8U6SHu8zHvhe1jvwX0rn4p973394geOQ26UNS"));
        // Assert.assertTrue(passwordEncoder.matches("$2a$10$9pJNjyj/800iO5CC8U6SHu8zHvhe1jvwX0rn4p973394geOQ26UNS", password));
    }
}