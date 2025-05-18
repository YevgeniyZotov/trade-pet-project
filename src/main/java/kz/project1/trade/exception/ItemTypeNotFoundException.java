package kz.project1.trade.exception;

public class ItemTypeNotFoundException extends IllegalArgumentException {
    public ItemTypeNotFoundException(String message) {
        super(message);
    }
}
