package bank;

import bank.entity.*;
import java.util.Date;
import bank.entity.helpClass.FullName;
import bank.entity.helpClass.StatusATM;
import bank.service.impl.*;
import bank.entity.helpClass.StatusOffice;

public class Main {
    public static void main(String[] args) {
        //Bank
        Bank bank = new Bank(1, "Сейф");
        BankServiceImpl bankService = new BankServiceImpl();
        System.out.println("Банк:");
        System.out.println("Название банк = " + bank.getNameBank());
        System.out.println("Старая сумма = " + bank.getMoneyBank());
        bankService.addMoney(bank,10000.0);
        System.out.println("Новая сумма = " + bank.getMoneyBank());
        bankService.subtractMoney(bank,5000.0);
        System.out.println("Изменённая сумма = " + bank.getMoneyBank());

        //Bank Office
        System.out.println("\n\nОфис:");
        BankOffice office = new BankOffice(bank, 1, "Копилка", "Улица Рубинштейна д.35",
                StatusOffice.Work, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,0.0,5.0);
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        System.out.println("Название офиса = " + office.getNameOffice());
        System.out.println("Адресс офиса = " + office.getAddress());
        System.out.println("Старая сумма офиса = " + office.getMoneyOffice());
        System.out.println("Старое количество банкоматов = " + office.getCountATMOffice());
        bankOfficeService.addMoney(office, 1000.0);
        bankOfficeService.addATM(office);
        System.out.println("Новая сумма  офиса= " + office.getMoneyOffice());
        System.out.println("Новая сумма банка = " + office.getMoneyBank());
        System.out.println("Новое количество банкоматов офиса = " + office.getCountATMOffice());
        System.out.println("Новое количество банкоматов банка = " + office.getCountATMBank());

        //Employee
        System.out.println("\n\nРаботник:");
        Employee employee = new Employee(office, 1, new FullName("Дмитрий", "Юрьевич", "Пучков"),
                new Date(10112000), "Менеджер", Boolean.FALSE, Boolean.TRUE, 1000.0);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        FullName fullName= employee.getFullNameEmployee();
        System.out.println("ФИО работника = " + fullName.getName() + " " + fullName.getMiddleName() + " " + fullName.getSurname());
        System.out.println("Должность работника = " + employee.getJob());
        if (employee.getDistantWork())
            System.out.println("Работает дома");
        else System.out.println("Работает в офисе");
        employeeService.toDistantWork(employee);
        if (employee.getDistantWork())
            System.out.println("Работает дома");
        else System.out.println("Работает в офисе");

        //Bank ATM
        System.out.println("\n\nБанкомат:");
        BankATM atm = new BankATM(employee, 1, "ATM_1", StatusATM.Work, Boolean.TRUE, Boolean.TRUE,
                500.0, 100.0);
        AtmServiceImpl atmService = new AtmServiceImpl();
        System.out.println("Старая сумма банкомата = " + atm.getMoneyATM());
        atmService.addMoney(atm, 1000.0);
        System.out.println("Новая сумма банкомата = " + atm.getMoneyATM());
        System.out.println("Новая сумма офиса = " + atm.getMoneyOffice());
        System.out.println("Новая сумма банка = " + atm.getMoneyBank());

        //User
        System.out.println("\n\nКлиент банка:");
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User(bank, 1, new FullName("Клим", "Жуков"), new Date(10112000),
                "Историк");
        fullName = user.getFullNameUser();
        System.out.println("Имя и фамилия клиента = " + fullName.getName() + " " + fullName.getSurname());
        System.out.println("Старая работа клиента банка = " + user.getWorkUser());
        System.out.println("Старая зарплата клиента банка = " + user.getMonthSalary());
        System.out.println("Старый рейтинг клиента банка = " + user.getCreditRating());
        userService.changeWork(user, "Археолог", 7000.0);
        System.out.println("Новая работа клиента банка = " + user.getWorkUser());
        System.out.println("Новая зарплата клиента банка = " + user.getMonthSalary());
        System.out.println("Новая рейтинг клиента банка = " + user.getCreditRating());

        //Payment Account
        System.out.println("\n\nПлатежный счет,:");
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount payAcc = new PaymentAccount(user, 1);
        System.out.println("Старая сумма платёжного счёта аккаунта = " + payAcc.getAmountPayAcc());
        paymentAccountService.addMoney(payAcc, 5000.0);
        System.out.println("Новая сумма платёжного счёта = " + payAcc.getAmountPayAcc());
        System.out.println("Новая сумма банка = " + payAcc.getMoneyBank());

        //Credit Account
        System.out.println("\n\nКредитный аккаунт:");
        CreditAccount creditAcc = new CreditAccount(payAcc, 1, new Date(10112020), new Date(10112021),
                12, 150.0, 1);
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
        if (creditAccountService.applyLoan(creditAcc, employee) )
            System.out.println("Удалось получить кредит");
        else System.out.println("Не удалось получить кредит");
    }
}