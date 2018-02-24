package crm.app.services.user.utils;

import crm.app.services.user.exception.InvalidValueException;
import org.springframework.util.StringUtils;

public class ValueValidator {
    public static void isValue(String value) throws InvalidValueException {
        if (StringUtils.isEmpty(value)) {
            throw new InvalidValueException("Value cannot be empty or null");
        }
    }
}
