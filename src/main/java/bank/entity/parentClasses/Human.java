package bank.entity.parentClasses;

import bank.entity.helpClass.FullName;

import java.util.Date;

public class Human {
    private Integer id;
    private FullName name;
    private Date birthDay;

    public Human(Integer id, FullName name, Date birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FullName getName() {return name;}

    public void setName(FullName name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
