package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 4/7/17.
 */
public class ClientAccountResponse implements Serializable {

    private List<LoanAccount> loanAccounts;

    private List<SavingsAccount> savingsAccounts;

    public List<LoanAccount> getLoanAccounts() {
        return loanAccounts;
    }

    public void setLoanAccounts(List<LoanAccount> loanAccounts) {
        this.loanAccounts = loanAccounts;
    }

    public List<SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }

    public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
        this.savingsAccounts = savingsAccounts;
    }

    public static class LoanAccount implements Serializable {

        private Long id;

        private String accountNo;

        private String externalId;

        private Long productId;

        private String productName;

        private Status status;

        private LoanType loanType;

        private Long loanCycle;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getExternalId() {
            return externalId;
        }

        public void setExternalId(String externalId) {
            this.externalId = externalId;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public LoanType getLoanType() {
            return loanType;
        }

        public void setLoanType(LoanType loanType) {
            this.loanType = loanType;
        }

        public Long getLoanCycle() {
            return loanCycle;
        }

        public void setLoanCycle(Long loanCycle) {
            this.loanCycle = loanCycle;
        }
    }

    public static class SavingsAccount implements Serializable {

        private Long id;

        private String accountNo;

        private Long productId;

        private String productName;

        private Status status;

        private Currency currency;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public Currency getCurrency() {
            return currency;
        }

        public void setCurrency(Currency currency) {
            this.currency = currency;
        }
    }

    public static class Status implements Serializable {

        private Long id;

        private String code;

        private String value;

        private boolean submittedAndPendingApproval;

        private boolean approved;

        private boolean rejected;

        private boolean withdrawnByApplicant;

        private boolean active;

        private boolean closed;

        private boolean overpaid;

        private boolean closedRescheduled;

        private boolean closedWrittenOff;

        private boolean closedObligationsMet;

        private boolean waitingForDisbursal;

        private boolean pendingApproval;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isSubmittedAndPendingApproval() {
            return submittedAndPendingApproval;
        }

        public void setSubmittedAndPendingApproval(boolean submittedAndPendingApproval) {
            this.submittedAndPendingApproval = submittedAndPendingApproval;
        }

        public boolean isApproved() {
            return approved;
        }

        public void setApproved(boolean approved) {
            this.approved = approved;
        }

        public boolean isRejected() {
            return rejected;
        }

        public void setRejected(boolean rejected) {
            this.rejected = rejected;
        }

        public boolean isWithdrawnByApplicant() {
            return withdrawnByApplicant;
        }

        public void setWithdrawnByApplicant(boolean withdrawnByApplicant) {
            this.withdrawnByApplicant = withdrawnByApplicant;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public boolean isClosed() {
            return closed;
        }

        public void setClosed(boolean closed) {
            this.closed = closed;
        }

        public boolean isOverpaid() {
            return overpaid;
        }

        public void setOverpaid(boolean overpaid) {
            this.overpaid = overpaid;
        }

        public boolean isClosedRescheduled() {
            return closedRescheduled;
        }

        public void setClosedRescheduled(boolean closedRescheduled) {
            this.closedRescheduled = closedRescheduled;
        }

        public boolean isClosedWrittenOff() {
            return closedWrittenOff;
        }

        public void setClosedWrittenOff(boolean closedWrittenOff) {
            this.closedWrittenOff = closedWrittenOff;
        }

        public boolean isClosedObligationsMet() {
            return closedObligationsMet;
        }

        public void setClosedObligationsMet(boolean closedObligationsMet) {
            this.closedObligationsMet = closedObligationsMet;
        }

        public boolean isWaitingForDisbursal() {
            return waitingForDisbursal;
        }

        public void setWaitingForDisbursal(boolean waitingForDisbursal) {
            this.waitingForDisbursal = waitingForDisbursal;
        }

        public boolean isPendingApproval() {
            return pendingApproval;
        }

        public void setPendingApproval(boolean pendingApproval) {
            this.pendingApproval = pendingApproval;
        }
    }

    public static class LoanType implements Serializable {

        private Long id;

        private String code;

        private String value;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class Currency implements Serializable {

        private String code;

        private String name;

        private Integer decimalPlaces;

        private String displaySymbol;

        private String nameCode;

        private String displayLabel;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getDecimalPlaces() {
            return decimalPlaces;
        }

        public void setDecimalPlaces(Integer decimalPlaces) {
            this.decimalPlaces = decimalPlaces;
        }

        public String getDisplaySymbol() {
            return displaySymbol;
        }

        public void setDisplaySymbol(String displaySymbol) {
            this.displaySymbol = displaySymbol;
        }

        public String getNameCode() {
            return nameCode;
        }

        public void setNameCode(String nameCode) {
            this.nameCode = nameCode;
        }

        public String getDisplayLabel() {
            return displayLabel;
        }

        public void setDisplayLabel(String displayLabel) {
            this.displayLabel = displayLabel;
        }
    }
}
