package bank.entity.exceptions;

public class AtmAnotherOfficeException extends Exception {
    public AtmAnotherOfficeException() {
        super("Банкомат принадлежит другому офису");
    }
}
