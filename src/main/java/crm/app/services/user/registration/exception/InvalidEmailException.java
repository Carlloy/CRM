package crm.app.services.user.registration.exception;

public class InvalidEmailException extends InvalidCredentialsException{
    public InvalidEmailException(String message) {
        super(message);
    }
}
