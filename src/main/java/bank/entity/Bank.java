package bank.entity;

import java.util.Random;

public class Bank {
    private Integer idBank;
    private String nameBank;
    private Integer countOffice;
    private Integer countATMBank;
    private Integer countEmployeesBank;
    private Integer countClients;
    private Integer rating;
    private Double moneyBank;
    private Double interestRate;

    public Bank(Integer idBank, String nameBank) {
        setIdBank(idBank);
        setNameBank(nameBank);
        setCountOffice(0);
        setCountATMBank(0);
        setCountEmployeesBank(0);
        setCountClients(0);
        Random random = new Random();
        setRating(random.nextInt(0, 100));
        setMoneyBank(random.nextDouble(0, 1000000));
        setInterestRate(20.0 - this.rating / 5);
    }

    public Bank(Bank oldBank) {
        setIdBank(oldBank.getIdBank());
        setNameBank(oldBank.getNameBank());
        setCountOffice(oldBank.getCountOffice());
        setCountATMBank(oldBank.getCountATMBank());
        setCountEmployeesBank(oldBank.getCountEmployeesBank());
        setCountClients(oldBank.getCountClients());
        setRating(oldBank.getRating());
        setMoneyBank(oldBank.getMoneyBank());
        setInterestRate(oldBank.getInterestRate());
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public Integer getCountOffice() {
        return countOffice;
    }

    public void setCountOffice(Integer countOffice) {
        this.countOffice = countOffice;
    }

    public Integer getCountATMBank() {
        return countATMBank;
    }

    public void setCountATMBank(Integer countATM) {
        this.countATMBank = countATM;
    }

    public Integer getCountEmployeesBank() {
        return countEmployeesBank;
    }

    public void setCountEmployeesBank(Integer countEmployeesBank) {
        this.countEmployeesBank = countEmployeesBank;
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

    public Double getMoneyBank() {
        return moneyBank;
    }

    public void setMoneyBank(Double moneyBank) {
        this.moneyBank = moneyBank;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}