package bank.service.impl;

import bank.entity.*;
import bank.entity.jsonClasses.JsonCreditAcc;
import bank.entity.jsonClasses.JsonPayAcc;
import bank.enums.StatusATM;
import bank.enums.StatusOffice;
import bank.exceptions.*;
import bank.service.BankService;
import bank.service.CreditAccountService;
import bank.service.PaymentAccountService;
import bank.service.UserService;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class UserServiceImpl implements UserService {
    private User user = null;
    Gson gson = new Gson();
    Type payAccArrType = new TypeToken<ArrayList<JsonPayAcc>>() {}.getType();
    Type credAccArrType = new TypeToken<ArrayList<JsonCreditAcc>>() {}.getType();

    /*Создание экземпляра пользователя*/
    @Override
    public void create(Integer id, String name, String surname, LocalDate birthDay, String work) {
        this.user = new User(id, name, surname, birthDay, work);
        calcSalary();
        calcCreditRating();
    }

    /*Обновление экземпляра пользователя*/
    @Override
    public void update(User user) {
        this.user = user;
    }

    /*Обнуление экземпляра пользователя*/
    @Override
    public void delete() {
        this.user = null;
    }

    /*Возврат экземпляра пользователя*/
    @Override
    public User getUser() {
        return this.user;
    }

    /*Получение зарплаты пользователя рандомом*/
    private void calcSalary() {
        Random random = new Random();
        user.setMonthSalary(random.nextDouble(1, 10000));
    }

    /*Получение кретитного рейтинга пользователя рандомом*/
    private void calcCreditRating() {
        int creditRating = 0;
        Integer startRat = 0;
        Integer endRat = 1000;
        while ((startRat != 10000) && (creditRating == 0)) {
            if ((user.getMonthSalary() <= endRat) && (user.getMonthSalary() >= startRat))
                creditRating = endRat / 10;
            else {
                startRat += 1000;
                endRat += 1000;
            }
        }
        user.setCreditRating(creditRating);
    }

    /*Добавление банка в список банков клиента*/
    @Override
    public void addBank(Bank bank) {
        ArrayList<Bank> banks = this.user.getBanks();
        banks.add(bank);
        this.user.setBanks(banks);
    }

    /*Удаление банка из списка банков клиента*/
    @Override
    public void delBank(Bank bank) {
        ArrayList<Bank> banks = this.user.getBanks();
        banks.remove(bank);
        this.user.setBanks(banks);
    }

    /*Добавление кредитного счёта в список кредитных счетов клиента*/
    @Override
    public void addCreditAcc(CreditAccountService creditAcc) throws CreditAccAnotherUserException {
        if (!Objects.equals(creditAcc.getCreditAcc().getUser(), this.user))
            throw new CreditAccAnotherUserException();
        ArrayList<CreditAccount> creditAccounts = this.user.getCreditAccounts();
        creditAccounts.add(creditAcc.getCreditAcc());
        this.user.setCreditAccounts(creditAccounts);
        creditAcc.getCreditAcc().setUser(this.user);
    }

    /*Удаление кредитного счёта из списка кредитных счетов клиента*/
    @Override
    public Boolean delCreditAcc(CreditAccountService creditAcc) {
        if (!Objects.equals(creditAcc.getCreditAcc().getUser(), this.user))
            return false;
        ArrayList<CreditAccount> creditAccounts = this.user.getCreditAccounts();
        creditAccounts.remove(creditAcc.getCreditAcc());
        this.user.setCreditAccounts(creditAccounts);
        creditAcc.getCreditAcc().setUser(this.user);
        return true;
    }

    /*Добавление платёжного счёта в список платёжных счетов клиента*/
    @Override
    public void addPayAcc(PaymentAccountService payAcc) throws PayAccAnotherUserException {
        if (!Objects.equals(payAcc.getPayAcc().getUser(), this.user))
            throw new PayAccAnotherUserException();
        ArrayList<PaymentAccount> paymentAccounts = this.user.getPaymentAccounts();
        paymentAccounts.add(payAcc.getPayAcc());
        this.user.setPaymentAccounts(paymentAccounts);
        payAcc.getPayAcc().setUser(this.user);
    }

    /*Удаление платёжного счёта из списка платёжных счетов клиента*/
    @Override
    public Boolean delPayAcc(PaymentAccountService payAcc) {
        if (!Objects.equals(payAcc.getPayAcc().getUser(), this.user))
            return false;
        ArrayList<PaymentAccount> paymentAccounts = this.user.getPaymentAccounts();
        paymentAccounts.remove(payAcc.getPayAcc());
        this.user.setPaymentAccounts(paymentAccounts);
        payAcc.getPayAcc().setUser(this.user);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder returnStr = new StringBuilder(this.user.toString());
        returnStr.append("\n\nПлатёжные счета клиента:");
        for (int i_1 = 0; i_1 < this.user.getPaymentAccounts().size(); i_1++) {
            returnStr.append(String.format("\n\n#№%d\n", i_1));
            returnStr.append(user.getPaymentAccounts().get(i_1).toString());
        }
        returnStr.append("\n\nКредитные счета клиента:");
        for (int i_1 = 0; i_1 < this.user.getCreditAccounts().size(); i_1++) {
            returnStr.append(String.format("\n\n#№%d\n", i_1));
            returnStr.append(user.getCreditAccounts().get(i_1).toString());
        }
        return returnStr.toString();
    }

    @Override
    public void saveToFile(String fileName, BankService bank) throws IOException {
        String payAccStr = gson.toJson(this.makeJsonPayAcc(bank.getBank().getId()));
        String creditAccStr = gson.toJson(this.makeJsonCreditAcc(bank.getBank().getId()));
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);
        writer.write("Платёжные счета:\n" + payAccStr + "\n\nКредитные счета:\n" + creditAccStr);
        writer.close();
    }

    @Override
    public void updateFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        boolean first = true;
        while (line != null) {
            if (!line.isEmpty()) {
                if (line.charAt(0) == '[') {
                    if (first) {
                        first = false;
                        this.makePayAccFromJson(gson.fromJson(line, payAccArrType));
                    } else {
                        this.makeCreditAccFromJson(gson.fromJson(line, credAccArrType));
                    }
                }
            }
            line = reader.readLine();
        }
    }

    /*Смена работы пользователя, а так же и заработной платы, и пересчёт его кредитного рейтинга*/
    @Override
    public void changeWork(String newWork, Double newMonthSalary) {
        user.setWork(newWork);
        user.setMonthSalary(newMonthSalary);
        int creditRating = 0;
        int startRat = 0;
        int endRat = 1000;
        while ((startRat != 10000) && (creditRating == 0)) {
            if ((newMonthSalary <= endRat) && (newMonthSalary >= startRat))
                creditRating = endRat / 10;
            else {
                startRat += 1000;
                endRat += 1000;
            }
        }
        user.setCreditRating(creditRating);
    }

    /*Смена заработной платы пользователя, а так же и пересчёт его кредитного рейтинга*/
    @Override
    public void changeMonthSalary(Double newMonthSalary) {
        user.setMonthSalary(newMonthSalary);
        int creditRating = 0;
        int startRat = 0;
        int endRat = 1000;
        while ((startRat != 10000) && (creditRating == 0)) {
            if ((newMonthSalary <= endRat) && (newMonthSalary >= startRat))
                creditRating = endRat / 10;
            else {
                startRat += 1000;
                endRat += 1000;
            }
        }
        user.setCreditRating(creditRating);
    }

    @Override
    public void applyLoan(BankService bank, BankOffice bankOffice, Employee employee, BankATM bankATM, Double sumCredit,
                   LocalDate startDate, Integer countMonths, PaymentAccountService paymentAccount,
                   CreditAccountService creditAccount) throws CreditException, BadUserRatingException,
            PayAccAnotherUserException, UserAnotherBankException, CreditAccAnotherUserException{

        if (this.user.getCreditRating()/10 < bank.getBank().getRating()) {
            throw new BadUserRatingException(bank.getBank().getRating(),
                    this.user.getCreditRating()/10);
        }
        if (bankOffice.getStatus() != StatusOffice.Work)
            throw new CreditException("Выбранный офис не работает");
        if (bankOffice.getMoney() < sumCredit)
            throw new CreditException("В выбранном офисе недостаточно денег");
        if (bankATM.getStatus() != StatusATM.Work)
            throw new CreditException("Банкомат, в выбранном офисе, не работает");
        if (bankATM.getMoney() < sumCredit)
            throw new CreditException("В выбранном банкомате недостаточно денег");
        if (!employee.getCanIssue())
            throw new CreditException("Выбранный сотрудник не может выдавать кредиты");

        if (!bank.getBank().getClients().contains(this.user)) {
            paymentAccount.create(100, this.user, bank.getBank());
            this.addPayAcc(paymentAccount);
            bank.addUser(this);
        }
        else {
            paymentAccount.update(this.getPayAccByBank(bank.getBank()));
        }
        creditAccount.create(100, this.user, bank.getBank(), employee, paymentAccount.getPayAcc(), startDate,
                countMonths, sumCredit);
        this.addCreditAcc(creditAccount);
    }

    private PaymentAccount getPayAccByBank(Bank bank) {
        for (int i = 0; i < this.user.getPaymentAccounts().size(); i++) {
            if (Objects.equals(this.user.getPaymentAccounts().get(i).getBank().getId(), bank.getId())) {
                return this.user.getPaymentAccounts().get(i);
            }
        }
        return null;
    }

    private ArrayList<JsonPayAcc> makeJsonPayAcc(Integer bankID) {
        ArrayList<JsonPayAcc> jsonPay = new ArrayList<>();
        for (PaymentAccount paymentAccount : user.getPaymentAccounts()) {
            if (Objects.equals(paymentAccount.getBank().getId(), bankID)) {
                jsonPay.add(new JsonPayAcc(paymentAccount));
            }
        }
        return jsonPay;
    }

    private void makePayAccFromJson(ArrayList<JsonPayAcc> jsonPayAcc) {
        ArrayList<PaymentAccount> payAcc = this.user.getPaymentAccounts();
        if (!jsonPayAcc.isEmpty()) {
            for (int i = 0; i < payAcc.size(); i++) {
                for (int j = 0; j < payAcc.size(); j++) {
                    if (Objects.equals(payAcc.get(i).getId(), jsonPayAcc.get(j).getId())) {
                        payAcc.get(i).updateFromJsonClass(jsonPayAcc.get(j));
                    }
                }
            }
            this.user.setPaymentAccounts(payAcc);
        }
    }

    private ArrayList<JsonCreditAcc> makeJsonCreditAcc(Integer bankID) {
        ArrayList<JsonCreditAcc> jsonCredit = new ArrayList<>();
        for (CreditAccount creditAccount : user.getCreditAccounts()) {
            if (Objects.equals(creditAccount.getBank().getId(), bankID)) {
                jsonCredit.add(new JsonCreditAcc(creditAccount));
            }
        }
        return jsonCredit;
    }

    private void makeCreditAccFromJson(ArrayList<JsonCreditAcc> jsonCreditAcc) {
        ArrayList<CreditAccount> creditAccounts = this.user.getCreditAccounts();
        if (!jsonCreditAcc.isEmpty()) {
            for (int i = 0; i < creditAccounts.size(); i++) {
                for (int j = 0; j < creditAccounts.size(); j++) {
                    if (Objects.equals(creditAccounts.get(i).getId(), jsonCreditAcc.get(j).getId())) {
                        creditAccounts.get(i).updateFromJsonClass(jsonCreditAcc.get(j));
                    }
                }
            }
            this.user.setCreditAccounts(creditAccounts);
        }
    }
}