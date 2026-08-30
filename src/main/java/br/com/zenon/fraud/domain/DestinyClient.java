package br.com.zenon.fraud.domain;

import java.math.BigDecimal;

public class DestinyClient {
    private String nameDest;
    private BigDecimal oldBalanceDest;
    private BigDecimal newBalanceDest;

    public DestinyClient(String nameDest, BigDecimal oldBalanceDest, BigDecimal newBalanceDest) throws Exception {
        this.setNameDest(nameDest);
        this.setOldBalanceDest(oldBalanceDest);
        this.setNewBalanceDest(newBalanceDest);
    }

    private void setNameDest(String nameDest) throws Exception {
        if (nameDest == null) {
            throw new Exception("NameDest não pode ser nulo.");
        }
        this.nameDest = nameDest;
    }

    private void setOldBalanceDest(BigDecimal oldBalanceDest) throws Exception {
        if (oldBalanceDest == null) {
            throw new Exception("OldBalanceDest não pode ser nulo.");
        }
        if (oldBalanceDest.signum() < 0) {
            throw new Exception("OldBalanceDest não pode ser menor que zero.");
        }

        this.oldBalanceDest = oldBalanceDest;
    }

    private void setNewBalanceDest(BigDecimal newBalanceDest) throws Exception {
        if (newBalanceDest == null) {
            throw new Exception("NewBalanceDest não pode ser nulo.");
        }
        if (newBalanceDest.signum() < 0) {
            throw new Exception("NewBalanceDest não pode ser menor que zero.");
        }

        this.newBalanceDest = newBalanceDest;
    }

    public String getNameDest() {
        return nameDest;
    }

    public BigDecimal getOldbalanceDest() {
        return oldBalanceDest;
    }

    public BigDecimal getNewbalanceDest() {
        return newBalanceDest;
    }
}
