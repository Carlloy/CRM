package crm.app.services.user.exception;

public class InvalidEmailException extends InvalidCredentialsException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
