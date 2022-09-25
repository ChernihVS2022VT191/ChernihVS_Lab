package bank.entity;

import bank.entity.helpClass.FullName;

import java.util.Date;
import java.util.Random;

public class User extends Bank{
    private Integer idUser;
    private FullName fullNameUser;
    private Date birthDayUser;
    private String workUser;
    private Double monthSalary;
    private Integer creditRating;

    public User(Bank oldBank, Integer idUser, FullName fullNameUser, Date birthDayUser, String workUser) {
        super(oldBank);
        this.setIdUser(idUser);
        this.setFullNameUser(fullNameUser);
        this.setBirthDayUser(birthDayUser);
        this.setWorkUser(workUser);
        Random random = new Random();
        this.setMonthSalary(random.nextDouble(1, 10000));
        int creditRating = 0;
        Integer startRat = 0;
        Integer endRat = 1000;
        while ((startRat != 10000) && (creditRating == 0)) {
            if ((getMonthSalary() <= endRat) && (getMonthSalary() >= startRat))
                creditRating = endRat / 10;
            else {
                startRat += 1000;
                endRat += 1000;
            }
        }
        this.setCreditRating(creditRating);
    }

    public User(User oldUser) {
        super(oldUser);
        this.setIdUser(oldUser.getIdUser());
        this.setFullNameUser(oldUser.getFullNameUser());
        this.setBirthDayUser(oldUser.getBirthDayUser());
        this.setWorkUser(oldUser.getWorkUser());
        this.setMonthSalary(oldUser.getMonthSalary());
        this.setCreditRating(oldUser.getCreditRating());
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public FullName getFullNameUser() {
        return fullNameUser;
    }

    public void setFullNameUser(FullName fullNameUser) {
        this.fullNameUser = fullNameUser;
    }

    public Date getBirthDayUser() {
        return birthDayUser;
    }

    public void setBirthDayUser(Date birthDayUser) {
        this.birthDayUser = birthDayUser;
    }

    public String getWorkUser() {
        return workUser;
    }

    public void setWorkUser(String workUser) {
        this.workUser = workUser;
    }

    public Double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(Double monthSalary) {
        this.monthSalary = monthSalary;
    }

    public Integer getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Integer creditRating) {
        this.creditRating = creditRating;
    }
}
