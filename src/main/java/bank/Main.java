package bank;

import bank.entity.exceptions.*;
import bank.entity.helpClass.StatusATM;
import bank.entity.helpClass.StatusOffice;
import bank.service.impl.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws EmployeeAnotherBankException, EmployeeAnotherOfficeException,
            AtmAnotherOfficeException, AtmAnotherBankException, OfficeAnotherBankException, PayAccAnotherUserException,
            CreditAccAnotherUserException, UserAnotherBankException{
        ArrayList<BankServiceImpl> banks = new ArrayList<>();
        ArrayList<UserServiceImpl> users = new ArrayList<>();
        for (int i_1 = 0; i_1 < 5; i_1++) {
            BankServiceImpl bankService = new BankServiceImpl();
            bankService.create(i_1, String.format("Банк_№%d", i_1));
            for (int i_2 = 0; i_2 < 3; i_2++) {
                BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
                bankOfficeService.create(i_2 + i_1, String.format("Офис_№%d", i_2), bankService.getBank(),
                        String.format("Адрес%d", i_2), StatusOffice.Work, 15000.0);
                for (int i_3 = 0; i_3 < 5; i_3++) {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.create(i_3 + 5 * i_2 + 3 * i_1, String.format("Клим_%d", i_3 + 5 * i_2 + 3 * i_1), "Жуков",
                            LocalDate.of(1977, 3, 27), bankService.getBank(),
                            bankOfficeService.getBankOffice(), String.format("Работа_%d", i_3), 100.0);
                    bankOfficeService.addEmployee(employeeService);
                    bankService.addEmployee(employeeService);
                }
                AtmServiceImpl atmService = new AtmServiceImpl();
                atmService.create(i_2 + i_1, String.format("Банкомат_%d", i_2 + i_1), StatusATM.Work, Boolean.TRUE, Boolean.TRUE,
                        100.0, bankOfficeService.getBankOffice().getBank(),
                        bankOfficeService.getBankOffice(), bankOfficeService.getBankOffice().getEmployees().get(1));
                bankOfficeService.addBankATM(atmService);
                bankService.addBankATM(atmService);
                bankService.addBankOffice(bankOfficeService);
            }

            UserServiceImpl userService = new UserServiceImpl();
            userService.create(i_1, String.format("Дмитрий_%d", i_1), "Пучков", LocalDate.of(1961,
                    8, 2), String.format("Работа_%d", i_1));
            for (int i_2 = 0; i_2 < 2; i_2++) {
                PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
                paymentAccountService.create(i_2 + i_1, userService.getUser(), bankService.getBank());

                CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
                creditAccountService.create(i_2 + i_1, userService.getUser(), bankService.getBank(),
                        bankService.getBank().getEmployees().get(1), paymentAccountService.getPayAcc(),
                        LocalDate.of(2022, 11, 11), 12, 150.0);
                userService.addPayAcc(paymentAccountService);
                userService.addCreditAcc(creditAccountService);
            }
            bankService.addUser(userService);
            banks.add(bankService);
            users.add(userService);
        }

        System.out.println("Банк");
        System.out.println(banks.get(0));
        System.out.println("\n\nКлиент");
        System.out.println(users.get(0));
    }
}