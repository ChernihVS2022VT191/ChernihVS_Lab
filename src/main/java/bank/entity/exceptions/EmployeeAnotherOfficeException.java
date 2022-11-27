package bank.entity.exceptions;

public class EmployeeAnotherOfficeException extends Exception {
    public EmployeeAnotherOfficeException() {
        super("Работник принадлежит другому офису");
    }
}