package crm.app.services.user.exception;

public class InvalidValueException extends InvalidCredentialsException {
    public InvalidValueException(String message) {
        super(message);
    }
}
