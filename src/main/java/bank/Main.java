package bank;

import bank.entity.helpClass.StatusATM;
import bank.entity.helpClass.StatusOffice;
import bank.service.impl.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Bank
        System.out.println("Банк:");
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.create(1, "Cейф");
        System.out.println(bankService.getBank());

        //Bank Office
        System.out.println("\n\nОфис:");
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        bankOfficeService.create(1, "Копилка", bankService.getBank(), "Улица Рубинштейна д.35",
                StatusOffice.Work, 15000.0);
        System.out.println(bankOfficeService.getBankOffice());

        //Employee
        System.out.println("\n\nРаботник:");
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.create(1, "Дмитрий", "Пучков", LocalDate.of(1961, 8, 2),
                bankService.getBank(), bankOfficeService.getBankOffice(), "Переводчик", 100.0);
        System.out.println(employeeService.getEmployee());

        //Bank ATM
        System.out.println("\n\nБанкомат:");
        AtmServiceImpl atmService = new AtmServiceImpl();
        atmService.create(1, "ATM_1", StatusATM.Work, Boolean.TRUE, Boolean.TRUE,
                100.0, bankService.getBank(), bankOfficeService.getBankOffice(),
                employeeService.getEmployee());
        System.out.println(atmService.getBankATM());

        //User
        System.out.println("\n\nКлиент банка::");
        UserServiceImpl userService = new UserServiceImpl();
        userService.create(1, "Клим", "Жуков", LocalDate.of(1977, 3, 29),
                "Историк");
        System.out.println(userService.getUser());

        //Payment Account
        System.out.println("\n\nПлатежный счет:");
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        paymentAccountService.create(1, userService.getUser(), bankService.getBank());
        System.out.println(paymentAccountService.getPayAcc());

        //Credit Account
        System.out.println("\n\nКредитный аккаунт:");
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
        creditAccountService.create(1, userService.getUser(), bankService.getBank(), employeeService.getEmployee(),
                paymentAccountService.getPayAcc(), LocalDate.of(2022, 9, 11), 12,
                150.0);
        System.out.println(creditAccountService.getCreditAcc());

    }
}