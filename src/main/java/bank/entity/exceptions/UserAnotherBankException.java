package bank.entity.exceptions;

public class UserAnotherBankException extends Exception {
    public UserAnotherBankException() {
        super("Клиент принадлежит другому банку");
    }
}
