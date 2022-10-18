package bank.entity;

import java.util.Random;

public class Bank {
    private Integer id;
    private String name;
    private Integer countOffice;
    private Integer countATM;
    private Integer countEmployees;
    private Integer countClients;
    private Integer rating;
    private Double money;
    private Double interestRate;

    public Bank(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.countOffice = 0;
        this.countATM = 0;
        this.countEmployees = 0;
        this.countClients = 0;
        Random random = new Random();
        this.rating = random.nextInt(0, 100);
        this.money = random.nextDouble(0, 1000000);
        this.interestRate = 20.0 - this.getRating() / 5.0;
    }

    public Bank() {
        this.id = -1;
        this.name = "";
        this.countOffice = 0;
        this.countATM = 0;
        this.countEmployees = 0;
        this.countClients = 0;
        Random random = new Random();
        this.rating = random.nextInt(0, 100);
        this.money = random.nextDouble(0, 1000000);
        this.interestRate = 20.0 - this.getRating() / 5.0;
    }

    @Override
    public String toString() {
        return "Имя банка: " + name + "\nКоличество офисов: " + countOffice + "\nКоличество банкоматов: " + countATM +
                "\nКоличество сотрудников: " + countEmployees + "\nКоличество клиентов: " + countClients +
                "\nРейтинг: " + rating + "\nКоличество денег: " + money + "\nПроцентная ставка: " + interestRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountOffice() {
        return countOffice;
    }

    public void setCountOffice(Integer countOffice) {
        this.countOffice = countOffice;
    }

    public Integer getCountATM() {
        return countATM;
    }

    public void setCountATM(Integer countATM) {
        this.countATM = countATM;
    }

    public Integer getCountEmployees() {
        return countEmployees;
    }

    public void setCountEmployees(Integer countEmployees) {
        this.countEmployees = countEmployees;
    }

    public Integer getCountClients() {
        return countClients;
    }

    public void setCountClients(Integer countClients) {
        this.countClients = countClients;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}