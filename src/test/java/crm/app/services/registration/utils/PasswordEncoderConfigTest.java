package crm.app.services.registration.utils;

import crm.app.configuration.PasswordEncoderConfig;
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
        String encodedPassword = null;
        encodedPassword = passwordEncoder.encode(password);
        for (int i = 0; i < 10; i++) {
            System.out.println(passwordEncoder.encode(password));
        }
        Assert.assertEquals(passwordEncoder.encode(password), encodedPassword);
    }
}