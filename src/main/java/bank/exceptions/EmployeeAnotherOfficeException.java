package bank.exceptions;

public class EmployeeAnotherOfficeException extends Exception {
    public EmployeeAnotherOfficeException() {
        super("Работник принадлежит другому офису");
    }
}