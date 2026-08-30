package br.com.zenon.fraud.domain;

import java.math.BigDecimal;

public class DestinyClient {
    private String nameDest;
    private BigDecimal oldBalanceDest;
    private BigDecimal newBalanceDest;

    public DestinyClient(String nameDest, BigDecimal oldBalanceDest, BigDecimal newBalanceDest) {
        this.setNameDest(nameDest);
        this.setOldBalanceDest(oldBalanceDest);
        this.setNewBalanceDest(newBalanceDest);
    }

    private void setNameDest(String nameDest) {
        if (nameDest == null) {
            throw new IllegalArgumentException("NameDest não pode ser nulo.");
        }
        this.nameDest = nameDest;
    }

    private void setOldBalanceDest(BigDecimal oldBalanceDest) {
        if (oldBalanceDest == null) {
            throw new IllegalArgumentException("OldBalanceDest não pode ser nulo.");
        }
        if (oldBalanceDest.signum() < 0) {
            throw new IllegalArgumentException("OldBalanceDest não pode ser menor que zero.");
        }

        this.oldBalanceDest = oldBalanceDest;
    }

    private void setNewBalanceDest(BigDecimal newBalanceDest) {
        if (newBalanceDest == null) {
            throw new IllegalArgumentException("NewBalanceDest não pode ser nulo.");
        }
        if (newBalanceDest.signum() < 0) {
            throw new IllegalArgumentException("NewBalanceDest não pode ser menor que zero.");
        }

        this.newBalanceDest = newBalanceDest;
    }

    @Override
    public String toString() {
        return "DestinyClient[" +
                "nameDest='" + nameDest + '\'' +
                ", oldBalanceDest=" + oldBalanceDest +
                ", newBalanceDest=" + newBalanceDest +
                ']';
    }
}
