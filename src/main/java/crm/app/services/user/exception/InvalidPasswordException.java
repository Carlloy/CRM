package crm.app.services.user.exception;

public class InvalidPasswordException extends InvalidCredentialsException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
