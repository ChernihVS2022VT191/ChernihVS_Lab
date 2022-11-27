package bank.entity.exceptions;

public class EmployeeAnotherBankException extends Exception {
    public EmployeeAnotherBankException() {
        super("Работник принадлежит другому Банку");
    }
}
