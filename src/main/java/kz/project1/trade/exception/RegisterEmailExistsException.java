package kz.project1.trade.exception;

public class RegisterEmailExistsException extends IllegalArgumentException {
    public RegisterEmailExistsException(String message) {
        super(message);
    }
}
