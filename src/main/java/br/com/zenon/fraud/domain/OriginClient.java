package br.com.zenon.fraud.domain;

import java.math.BigDecimal;

public class OriginClient {
    private String nameOrig;
    private BigDecimal oldbalanceOrg;
    private BigDecimal newbalanceOrig;

    public OriginClient(String nameOrig, BigDecimal oldbalanceOrg, BigDecimal newbalanceOrig) throws Exception {
        this.setNameOrig(nameOrig);
        this.setOldbalanceOrg(oldbalanceOrg);
        this.setNewbalanceOrig(newbalanceOrig);
    }

    public void setNameOrig(String nameOrig) throws Exception {
        if (nameOrig == null) {
            throw new Exception("NameOrig não pode ser nulo");
        }
        this.nameOrig = nameOrig;
    }

    public void setOldbalanceOrg(BigDecimal oldbalanceOrg) throws Exception {
        if (oldbalanceOrg == null) {
            throw new Exception("OldbalanceOrg não pode ser nulo");
        }
        if (oldbalanceOrg.signum() < 0) {
            throw new Exception("OldbalanceOrg não pode ser menor que 0");
        }
        this.oldbalanceOrg = oldbalanceOrg;
    }

    public void setNewbalanceOrig(BigDecimal newbalanceOrig) throws Exception {
        if (newbalanceOrig == null) {
            throw new Exception("NewbalanceOrg não pode ser nulo");
        }
        if (newbalanceOrig.signum() < 0) {
            throw new Exception("NewbalanceOrg não pode ser menor que 0");
        }
        this.newbalanceOrig = newbalanceOrig;
    }

    public String getNameOrig() {
        return nameOrig;
    }

    public BigDecimal getOldbalanceOrg() {
        return oldbalanceOrg;
    }

    public BigDecimal getNewbalanceOrig() {
        return newbalanceOrig;
    }
}
