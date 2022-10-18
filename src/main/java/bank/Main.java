package bank;

import bank.entity.*;

import java.time.LocalDate;
import java.util.Calendar;
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
        System.out.println("Название банк = " + bank.getName());
        System.out.println("Старая сумма = " + bank.getMoney());
        bankService.addMoney(bank,10000.0);
        System.out.println("Новая сумма = " + bank.getMoney());
        bankService.subtractMoney(bank,5000.0);
        System.out.println("Изменённая сумма = " + bank.getMoney());
        System.out.println("\n" + bank);

        //Bank Office
        System.out.println("\n\nОфис:");
        BankOffice office = new BankOffice(1, "Копилка", bank, "Улица Рубинштейна д.35", StatusOffice.Work,
                15000.0);
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        System.out.println("Название офиса = " + office.getName());
        System.out.println("Адресс офиса = " + office.getAddress());
        System.out.println("Старая сумма офиса = " + office.getMoney());
        System.out.println("Старое количество банкоматов = " + office.getCountATM());
        bankOfficeService.addMoney(office, 1300.0);
        bankOfficeService.addATM(office);
        System.out.println("Новая сумма  офиса= " + office.getMoney());
        System.out.println("Новая сумма банка = " + office.getBank().getMoney());
        System.out.println("Новое количество банкоматов офиса = " + office.getCountATM());
        System.out.println("Новое количество банкоматов банка = " + office.getBank().getCountATM());
        System.out.println("\n" + office);

        //Employee
        System.out.println("\n\nРаботник:");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1961, Calendar.DECEMBER, 11);
        Date date = calendar.getTime();
        Employee employee = new Employee(1, new FullName("Дмитрий", "Юрьевич","Пучков"), date,
                bank, office, "Менеджер", 100.0);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        if (employee.getDistantWork())
            System.out.println("Работает дома");
        else System.out.println("Работает в офисе");
        //employeeService.toOfficeWork(employee);
        if (employee.getDistantWork())
            System.out.println("Работает дома");
        else System.out.println("Работает в офисе");
        System.out.println("\n" + employee);

        //Bank ATM
        System.out.println("\n\nБанкомат:");
        BankATM atm = new BankATM(1, "ATM_1", StatusATM.Work, Boolean.TRUE, Boolean.TRUE,
                100.0, bank, office, employee);
        AtmServiceImpl atmService = new AtmServiceImpl();
        System.out.println("Старая сумма банкомата = " + atm.getMoney());
        atmService.addMoney(atm, 1000.0);
        System.out.println("Новая сумма банкомата = " + atm.getMoney());
        System.out.println("Новая сумма офиса = " + atm.getBankOffice().getMoney());
        System.out.println("Новая сумма банка = " + atm.getBank().getMoney());
        System.out.println("\n" + atm);

        //User
        System.out.println("\n\nКлиент банка:");
        UserServiceImpl userService = new UserServiceImpl();
        calendar.set(1977, Calendar.MARCH, 2);
        date = calendar.getTime();
        User user = new User(1, new FullName("Клим", "Жуков"), date, "Историк");
        System.out.println("Старая работа клиента банка = " + user.getWork());
        System.out.println("Старая зарплата клиента банка = " + user.getMonthSalary());
        System.out.println("Старый рейтинг клиента банка = " + user.getCreditRating());
        userService.changeWork(user, "Археолог", 7000.0);
        System.out.println("Новая работа клиента банка = " + user.getWork());
        System.out.println("Новая зарплата клиента банка = " + user.getMonthSalary());
        System.out.println("Новая рейтинг клиента банка = " + user.getCreditRating());
        userService.changeMonthSalary(user, 8000.0);
        System.out.println("Новая зарплата клиента банка = " + user.getMonthSalary());
        System.out.println("Новая рейтинг клиента банка = " + user.getCreditRating());
        System.out.println("\n" + user);

        //Payment Account
        System.out.println("\n\nПлатежный счет,:");
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount payAcc = new PaymentAccount(1, user, bank);
        System.out.println("Старая сумма платёжного счёта аккаунта = " + payAcc.getAmount());
        paymentAccountService.addMoney(payAcc, 4000.0);
        System.out.println("Новая сумма платёжного счёта = " + payAcc.getAmount());
        System.out.println("Новая сумма банка = " + payAcc.getBank().getMoney());
        System.out.println("\n" + payAcc);

        //Credit Account
        System.out.println("\n\nКредитный аккаунт:");
        CreditAccount creditAcc = new CreditAccount(1, user, bank, employee, payAcc, LocalDate.of(2022, 9, 11),
                11, 150.0);
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
        if (creditAccountService.applyLoan(creditAcc, payAcc, employee))
            System.out.println("Удалось получить кредит");
        else System.out.println("Не удалось получить кредит");
        System.out.println("\n" + creditAcc);
    }
}