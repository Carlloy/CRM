package crm.app.services.registration.utils;

import crm.app.services.registration.exception.InvalidValueException;
import org.springframework.util.StringUtils;

public class ValueValidator {
    public static void isValue(String value) throws InvalidValueException {
        if(StringUtils.isEmpty(value)){
            throw new InvalidValueException("Value cannot be empty or null");
        }
    }
}
