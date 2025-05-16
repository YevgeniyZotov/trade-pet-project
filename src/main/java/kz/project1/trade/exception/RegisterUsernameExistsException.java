package kz.project1.trade.exception;

public class RegisterUsernameExistsException extends RuntimeException {
    public RegisterUsernameExistsException(String message) {
        super(message);
    }
}
