package bank.entity.exceptions;

public class PayAccAnotherUserException extends Exception {
    public PayAccAnotherUserException() {
        super("Платёжный счёт принадлежит другому клиенту");
    }
}
