package bank.entity.exceptions;

public class AtmAnotherBankException extends Exception {
    public AtmAnotherBankException() {
        super("Банкомат принадлежит другому банку");
    }
}
