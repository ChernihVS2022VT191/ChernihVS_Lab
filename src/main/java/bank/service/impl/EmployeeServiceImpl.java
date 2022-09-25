package bank.service.impl;

import bank.entity.Employee;
import bank.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    /*Отправка работника на удалённую работу*/
    @Override
    public void toDistantWork(Employee employee) {
        employee.setDistantWork(Boolean.TRUE);
    }

    /*Отправка работника на работу в офисе*/
    @Override
    public void toOfficeWork(Employee employee) {
        employee.setDistantWork(Boolean.FALSE);
    }
}
