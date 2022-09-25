package bank.entity;

public class BankATM extends Employee {
    private Integer idATM;
    private String nameATM;
    private int statusATM;
    private Boolean workPayMoney;
    private Boolean workDepositMoney;
    private Double moneyATM;
    private Double maintenanceCost;

    public BankATM(Employee oldEmployee, Integer idATM, String nameATM, int status, Boolean workPayMoney,
                   Boolean workDepositMoney, Double moneyATM, Double maintenanceCost) {
        super(oldEmployee);
        setIdATM(idATM);
        setNameATM(nameATM);
        setStatus(status);
        setWorkPayMoney(workPayMoney);
        setWorkDepositMoney(workDepositMoney);
        setMoneyATM(moneyATM);
        setMaintenanceCost(maintenanceCost);
    }

    public Integer getIdATM() {
        return idATM;
    }

    public void setIdATM(Integer idATM) {
        this.idATM = idATM;
    }

    public String getNameATM() {
        return nameATM;
    }

    public void setNameATM(String nameATM) {
        this.nameATM = nameATM;
    }

    public int getStatus() {
        return statusATM;
    }

    public void setStatus(int statusATM) {
        this.statusATM = statusATM;
    }

    public Boolean getWorkPayMoney() {
        return workPayMoney;
    }

    public void setWorkPayMoney(Boolean workPayMoney) {
        this.workPayMoney = workPayMoney;
    }

    public Boolean getWorkDepositMoney() {
        return workDepositMoney;
    }

    public void setWorkDepositMoney(Boolean workDepositMoney) {
        this.workDepositMoney = workDepositMoney;
    }

    public Double getMoneyATM() {
        return moneyATM;
    }

    public void setMoneyATM(Double moneyATM) {
        this.moneyATM = moneyATM;
    }

    public Double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(Double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }
}
