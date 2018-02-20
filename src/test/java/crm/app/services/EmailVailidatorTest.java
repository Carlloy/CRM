package crm.app.services;

import org.junit.Assert;
import org.junit.Test;

public class EmailVailidatorTest {
    @Test
    public void validate() throws Exception {
        Assert.assertTrue(EmailVailidator.validate("kacper.test@gmail.com"));
    }

}