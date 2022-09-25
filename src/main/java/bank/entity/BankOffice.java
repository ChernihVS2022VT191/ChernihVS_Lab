package bank.entity;

public class BankOffice extends Bank{
    private int idOffice;
    private String nameOffice;
    private String address;
    private int statusOffice;
    private boolean maySetATM;
    private int countATMOffice;
    private boolean mayApplyLoan;
    private boolean mayWithdrawMoney;
    private boolean mayDepositMoney;
    private double moneyOffice;
    private double rentCost;

    public BankOffice(Bank oldBank, int idOffice, String nameOffice, String address, int statusOffice,
                      boolean maySetATM, boolean mayApplyLoan, boolean mayWithdrawMoney,
                      boolean mayDepositMoney, double moneyOffice, double rentCost) {
        super(oldBank);
        this.setIdOffice(idOffice);
        this.setNameOffice(nameOffice);
        this.setAddress(address);
        this.setStatusOffice(statusOffice);
        this.setMaySetATM(maySetATM);
        this.setCountATMOffice(0);
        this.setMayApplyLoan(mayApplyLoan);
        this.setMayWithdrawMoney(mayWithdrawMoney);
        this.setMayDepositMoney(mayDepositMoney);
        this.setMoneyOffice(moneyOffice);
        this.setRentCost(rentCost);
    }

    public BankOffice(BankOffice oldOffice) {
        super(oldOffice);
        this.setIdOffice(oldOffice.getIdOffice());
        this.setNameOffice(oldOffice.getNameOffice());
        this.setAddress(oldOffice.getAddress());
        this.setStatusOffice(oldOffice.getStatusOffice());
        this.setMaySetATM(oldOffice.getMaySetATM());
        this.setCountATMOffice(oldOffice.getCountATMOffice());
        this.setMayApplyLoan(oldOffice.getMayApplyLoan());
        this.setMayWithdrawMoney(oldOffice.getMayWithdrawMoney());
        this.setMayDepositMoney(oldOffice.getMayDepositMoney());
        this.setMoneyOffice(oldOffice.getMoneyOffice());
        this.setRentCost(oldOffice.getRentCost());
    }

    public Integer getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(Integer idBank) {
        this.idOffice = idBank;
    }

    public String getNameOffice() {
        return nameOffice;
    }

    public void setNameOffice(String nameBank) {
        this.nameOffice = nameBank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatusOffice() {
        return statusOffice;
    }

    public void setStatusOffice(int statusOffice) {
        this.statusOffice = statusOffice;
    }

    public Boolean getMaySetATM() {
        return maySetATM;
    }

    public void setMaySetATM(Boolean maySetATM) {
        this.maySetATM = maySetATM;
    }

    public Integer getCountATMOffice() {
        return countATMOffice;
    }

    public void setCountATMOffice(Integer countATM) {
        this.countATMOffice = countATM;
    }

    public Boolean getMayApplyLoan() {
        return mayApplyLoan;
    }

    public void setMayApplyLoan(Boolean mayApplyLoan) {
        this.mayApplyLoan = mayApplyLoan;
    }

    public Boolean getMayWithdrawMoney() {
        return mayWithdrawMoney;
    }

    public void setMayWithdrawMoney(Boolean mayWithdrawMoney) {
        this.mayWithdrawMoney = mayWithdrawMoney;
    }

    public Boolean getMayDepositMoney() {
        return mayDepositMoney;
    }

    public void setMayDepositMoney(Boolean mayDepositMoney) {
        this.mayDepositMoney = mayDepositMoney;
    }

    public Double getMoneyOffice() {
        return moneyOffice;
    }

    public void setMoneyOffice(Double money) {
        this.moneyOffice = money;
    }

    public Double getRentCost() {
        return rentCost;
    }

    public void setRentCost(Double rentCost) {
        this.rentCost = rentCost;
    }
}
