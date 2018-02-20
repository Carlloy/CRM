package crm.app.services.registration.exception;

public class InvalidValueException extends InvalidCredentialsException{
    public InvalidValueException(String message) {
        super(message);
    }
}
