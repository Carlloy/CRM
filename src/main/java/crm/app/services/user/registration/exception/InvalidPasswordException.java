package crm.app.services.user.registration.exception;

public class InvalidPasswordException extends InvalidCredentialsException {
    public InvalidPasswordException(String message){
        super(message);
    }
}
