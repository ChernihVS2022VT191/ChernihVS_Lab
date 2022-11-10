package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl implements EmployeeService {
    private Employee employee = null;

    /*Создание экземпляра сотрудника*/
    @Override
    public void create(Integer id, String name, String surname, LocalDate birthday, Bank bank, BankOffice bankOffice,
                       String profession, Double salary) {
        bank.setCountEmployees(bank.getCountEmployees() + 1);
        this.employee = new Employee(id, name, surname, birthday, bank, bankOffice, profession, salary);
    }

    /*Обновление экземпляра сотрудника*/
    @Override
    public void update(Employee employee) {
        this.employee = employee;
    }

    /*Обнуление экземпляра сотрудника*/
    @Override
    public void delete() {
        this.employee = null;
    }

    /*Возврат экземпляра сотрудника*/
    @Override
    public Employee getEmployee() {
        return this.employee;
    }

    /*Отправка работника на удалённую работу*/
    @Override
    public void toDistantWork() {
        this.employee.setDistantWork(Boolean.TRUE);
    }

    /*Отправка работника на работу в офисе*/
    @Override
    public void toOfficeWork() {
        this.employee.setDistantWork(Boolean.FALSE);
    }

    /*Разрешить работнику выдавать кредиты*/
    @Override
    public void toCanIssue() {
        this.employee.setCanIssue(Boolean.TRUE);
    }

    /*Разрешить работнику выдавать кредиты*/
    @Override
    public void toCannotIssue() {
        this.employee.setCanIssue(Boolean.FALSE);
    }
}
