package bank.entity.helpClass;

public class FullName {
    private String name;
    private String surname;
    private String middleName = null;

    public FullName(String name, String middleName, String surname) {
        this.setName(name);
        this.setSurname(surname);
        this.setMiddleName(middleName);
    }

    public FullName(String name, String surname) {
        this.setName(name);
        this.setSurname(surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
