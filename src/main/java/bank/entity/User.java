package bank.entity;

import java.util.Date;
import java.util.Random;
import bank.entity.helpClass.FullName;
import bank.entity.parentClasses.Human;

public class User extends Human {
    private String work;
    private Double monthSalary;
    private Integer creditRating;

    public User(Integer id, FullName name, Date birthDay, String work) {
        super(id, name, birthDay);
        this.work = work;
        Random random = new Random();
        this.monthSalary = random.nextDouble(1, 10000);
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
        this.creditRating = creditRating;
    }

    public User() {
        super(-1, new FullName("", ""), new Date());
        this.work = "";
        Random random = new Random();
        this.monthSalary = random.nextDouble(1, 10000);
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
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        return "ФИО: " + super.getName().toString() + "\nДата рождения: " + super.getBirthDay() + "\nРабота: " +
                work + "\nЗарплата: " + monthSalary + "\nКредитный рейтинг: " + creditRating;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
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
