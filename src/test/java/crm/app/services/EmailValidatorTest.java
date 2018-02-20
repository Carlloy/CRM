package crm.app.services;

import crm.app.services.registration.utils.EmailValidator;
import org.junit.Assert;
import org.junit.Test;

public class EmailValidatorTest {
    @Test
    public void validate() throws Exception {
        Assert.assertTrue(EmailValidator.validate("kacper.test@gmail.com"));
        Assert.assertFalse(EmailValidator.validate("kacper.testgmail.com"));
    }

}