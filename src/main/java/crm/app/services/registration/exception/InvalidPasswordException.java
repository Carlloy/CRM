package crm.app.services.registration.exception;

public class InvalidPasswordException extends InvalidCredentialsException {
    public InvalidPasswordException(String message){
        super(message);
    }
}
