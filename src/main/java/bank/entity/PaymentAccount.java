package bank.entity;

public class PaymentAccount extends User {
    private Integer idPayAcc;
    private Double amountPayAcc;

    public PaymentAccount(User oldUser, Integer idPayAcc) {
        super(oldUser);
        this.setIdPayAcc(idPayAcc);
        this.setAmountPayAcc(0.0);
    }

    public PaymentAccount(PaymentAccount oldPayAcc) {
        super(oldPayAcc);
        this.setIdPayAcc(oldPayAcc.getIdPayAcc());
        this.setAmountPayAcc(oldPayAcc.getAmountPayAcc());
    }

    public Integer getIdPayAcc() {
        return idPayAcc;
    }

    public void setIdPayAcc(Integer idPayAcc) {
        this.idPayAcc = idPayAcc;
    }

    public Double getAmountPayAcc() {
        return amountPayAcc;
    }

    public void setAmountPayAcc(Double amountPayAcc) {
        this.amountPayAcc = amountPayAcc;
    }
}
