package bank.entity;

import bank.entity.helpClass.FullName;

import java.util.Date;

public class Employee extends BankOffice{
    private Integer idEmployee;
    private FullName fullNameEmployee;
    private Date birthDayEmployee;
    private String job;
    private Boolean distantWork;
    private Boolean canLend;
    private Double salary;

    public Employee(BankOffice oldOffice, Integer idEmployee, FullName fullNameEmployee, Date birthDayEmployee, String job,
                    Boolean distantWork, Boolean canLend, Double salary) {
        super(oldOffice);
        this.setIdEmployee(idEmployee);
        this.setFullNameEmployee(fullNameEmployee);
        this.setBirthDayEmployee(birthDayEmployee);
        this.setJob(job);
        this.setDistantWork(distantWork);
        this.setCanLend(canLend);
        this.setSalary(salary);
    }

    public Employee(Employee oldEmployee) {
        super(oldEmployee);
        this.setIdEmployee(oldEmployee.getIdEmployee());
        this.setFullNameEmployee(oldEmployee.getFullNameEmployee());
        this.setBirthDayEmployee(oldEmployee.getBirthDayEmployee());
        this.setJob(oldEmployee.getJob());
        this.setDistantWork(oldEmployee.getDistantWork());
        this.setCanLend(oldEmployee.getCanLend());
        this.setSalary(oldEmployee.getSalary());
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public FullName getFullNameEmployee() {
        return fullNameEmployee;
    }

    public void setFullNameEmployee(FullName fullNameEmployee) {
        this.fullNameEmployee = fullNameEmployee;
    }

    public Date getBirthDayEmployee() {
        return birthDayEmployee;
    }

    public void setBirthDayEmployee(Date birthDayEmployee) {
        this.birthDayEmployee = birthDayEmployee;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Boolean getDistantWork() {
        return distantWork;
    }

    public void setDistantWork(Boolean distantWork) {
        this.distantWork = distantWork;
    }

    public Boolean getCanLend() {
        return canLend;
    }

    public void setCanLend(Boolean canLend) {
        this.canLend = canLend;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
