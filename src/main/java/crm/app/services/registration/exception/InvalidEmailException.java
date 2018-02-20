package crm.app.services.registration.exception;

public class InvalidEmailException extends InvalidCredentialsException{
    public InvalidEmailException(String message) {
        super(message);
    }
}
