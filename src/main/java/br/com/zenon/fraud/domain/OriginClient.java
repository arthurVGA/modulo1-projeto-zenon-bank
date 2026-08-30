package br.com.zenon.fraud.domain;

import java.math.BigDecimal;

public class OriginClient {
    private String nameOrig;
    private BigDecimal oldBalanceOrg;
    private BigDecimal newBalanceOrig;

    public OriginClient(String nameOrig, BigDecimal oldBalanceOrg, BigDecimal newBalanceOrig) {
        this.setNameOrig(nameOrig);
        this.setOldBalanceOrg(oldBalanceOrg);
        this.setNewBalanceOrig(newBalanceOrig);
    }

    public void setNameOrig(String nameOrig) {
        if (nameOrig == null) {
            throw new IllegalArgumentException("NameOrig não pode ser nulo");
        }
        this.nameOrig = nameOrig;
    }

    public void setOldBalanceOrg(BigDecimal oldBalanceOrg) {
        if (oldBalanceOrg == null) {
            throw new IllegalArgumentException("OldBalanceOrg não pode ser nulo");
        }
        if (oldBalanceOrg.signum() < 0) {
            throw new IllegalArgumentException("OldBalanceOrg não pode ser menor que 0");
        }
        this.oldBalanceOrg = oldBalanceOrg;
    }

    public void setNewBalanceOrig(BigDecimal newBalanceOrig) {
        if (newBalanceOrig == null) {
            throw new IllegalArgumentException("NewBalanceOrg não pode ser nulo");
        }
        if (newBalanceOrig.signum() < 0) {
            throw new IllegalArgumentException("NewBalanceOrg não pode ser menor que 0");
        }
        this.newBalanceOrig = newBalanceOrig;
    }

    public String getNameOrig() {
        return nameOrig;
    }

    @Override
    public String toString() {
        return "OriginClient[" +
                "nameOrig='" + nameOrig + '\'' +
                ", oldbalanceOrg=" + oldBalanceOrg +
                ", newbalanceOrig=" + newBalanceOrig +
                ']';
    }
}
