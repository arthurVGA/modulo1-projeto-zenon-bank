package br.com.zenon.fraud.domain;

import java.math.BigDecimal;

public class Transaction {
    private int step;
    private TransactionType type;
    private BigDecimal amount;
    private OriginClient originClient;
    private DestinyClient destinyClient;
    private boolean isFraud;
    private boolean isFlaggedFraud;

    public Transaction(int step, String type, BigDecimal amount, String nameOrig, BigDecimal oldBalanceOrg, BigDecimal newBalanceOrig, String nameDest, BigDecimal oldBalanceDest, BigDecimal newBalanceDest, Integer isFraud, Integer isFlaggedFraud) throws Exception {
        this.setStep(step);
        this.setType(type);
        this.setAmount(amount);
        this.setOriginClient(nameOrig, oldBalanceOrg, newBalanceOrig);
        this.setDestinyClient(nameDest, oldBalanceDest, newBalanceDest);
        this.setIsFraud(isFraud);
        this.setIsFlaggedFraud(isFlaggedFraud);
    }

    public void setStep(int step) throws Exception {
        if (step <= 1) {
            throw new Exception("Step não pode ser menor que 1.");
        }
        this.step = step;
    }

    public void setType(String type) throws Exception {
        if (type == null) {
            throw new Exception("Type não pode ser nulo");
        }
        this.type = TransactionType.valueOf(type);
    }

    public void setAmount(BigDecimal amount) throws Exception {
        if (amount == null) {
            throw new Exception("Amount não pode ser nulo");
        }
        if (amount.signum() < 0) {
            throw new Exception("Amount não pode ser menor que 0.");
        }
        this.amount = amount;
    }

    public void setOriginClient(String nameOrig, BigDecimal oldBalanceOrg, BigDecimal newBalanceOrig) throws Exception {
        this.originClient = new OriginClient(nameOrig, oldBalanceOrg, newBalanceOrig);
    }

    public void setDestinyClient(String nameDest, BigDecimal oldBalanceDest, BigDecimal newBalanceDest) throws Exception {
        this.destinyClient = new DestinyClient(nameDest, oldBalanceDest, newBalanceDest);
    }

    public void setIsFraud(Integer isFraud) throws Exception {
        if (isFraud == null) {
            throw new Exception("IsFraud não pode ser nulo");
        }
        if (isFraud != 0 && isFraud != 1) {
            throw new Exception("IsFraud só pode ser zero ou um.");
        }
        this.isFraud = (isFraud == 1);
    }

    public void setIsFlaggedFraud(Integer isFlaggedFraud) throws Exception {
        if (isFlaggedFraud == null) {
            throw new Exception("IsFlaggedFraud não pode ser nulo");
        }
        if (isFlaggedFraud != 0 && isFlaggedFraud != 1) {
            throw new Exception("IsFlaggedFraud só pode ser zero ou um.");
        }
        this.isFlaggedFraud = (isFlaggedFraud == 1);
    }

    public int getStep() {
        return step;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public OriginClient getOriginClient() {
        return originClient;
    }

    public DestinyClient getDestinyClient() {
        return destinyClient;
    }

    public boolean isFraud() {
        return isFraud;
    }

    public boolean isFlaggedFraud() {
        return isFlaggedFraud;
    }

    @Override
    public String toString() {
        return "Transaction[" +
                "step=" + step +
                ", type=" + type +
                ", amount=" + amount +
                ", originClient=" + originClient +
                ", destinyClient=" + destinyClient +
                ", isFraud=" + isFraud +
                ", isFlaggedFraud=" + isFlaggedFraud +
                ']';
    }
}
