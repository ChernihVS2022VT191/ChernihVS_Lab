package bank.exceptions;

public class CreditAccAnotherUserException extends Exception {
    public CreditAccAnotherUserException() {
        super("Кредитный аккаунт принадлежит другому клиенту");
    }
}
