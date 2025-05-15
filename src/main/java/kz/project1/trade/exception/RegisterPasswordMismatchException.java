package kz.project1.trade.exception;

public class RegisterPasswordMismatchException extends IllegalArgumentException {
    public RegisterPasswordMismatchException(String message) {
        super(message);
    }
}
