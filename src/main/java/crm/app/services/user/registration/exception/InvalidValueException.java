package crm.app.services.user.registration.exception;

public class InvalidValueException extends InvalidCredentialsException{
    public InvalidValueException(String message) {
        super(message);
    }
}
