package bank.entity.exceptions;

public class OfficeAnotherBankException extends Exception {
    public OfficeAnotherBankException() {
        super("Офис принадлежит другому банку");
    }
}
