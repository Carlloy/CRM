package crm.app.services.user.utils;

import crm.app.services.user.exception.InvalidValueException;
import org.springframework.util.StringUtils;

public class ValueValidator {
    private ValueValidator() {
    }

    public static void isValue(String valueName, String value) throws InvalidValueException {
        if (StringUtils.isEmpty(value)) {
            throw new InvalidValueException("Value" + valueName + " cannot be empty or null");
        }
    }
}
