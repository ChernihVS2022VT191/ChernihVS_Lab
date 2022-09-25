package bank.entity;

import java.util.Date;

public class CreditAccount extends PaymentAccount {
    private Integer idCreditAcc;
    private Date startDate;
    private Date endDate;
    private Integer countMonth;
    private Double amountCreditAcc;
    private Integer employeeId;

    public CreditAccount(PaymentAccount oldPayAcc, Integer idCreditAcc, Date startDate, Date endDate, Integer countMonth,
                         Double amountCreditAcc, Integer employeeId) {
        super(oldPayAcc);
        this.setIdCreditAcc(idCreditAcc);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setCountMonth(countMonth);
        this.setAmountCreditAcc(amountCreditAcc);
        this.setEmployeeId(employeeId);
    }

    public Integer getIdCreditAcc() {
        return idCreditAcc;
    }

    public void setIdCreditAcc(Integer idCreditAcc) {
        this.idCreditAcc = idCreditAcc;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(Integer countMonth) {
        this.countMonth = countMonth;
    }

    public Double getAmountCreditAcc() {
        return amountCreditAcc;
    }

    public void setAmountCreditAcc(Double amountCreditAcc) {
        this.amountCreditAcc = amountCreditAcc;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
