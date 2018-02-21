package crm.app.services.registration.utils;

import crm.app.services.registration.exception.InvalidValueException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ValueValidatorTest {

    @Test(expected = InvalidValueException.class)
    public void when_value_is_null()throws InvalidValueException{
    ValueValidator.isValue(null);
}
    @Test(expected = InvalidValueException.class)
    public void when_value_is_empty()throws InvalidValueException{
        ValueValidator.isValue("");
    }

    @Test
    public void when_value_exists() throws InvalidValueException{
        ValueValidator.isValue("wartość");
    }

}
