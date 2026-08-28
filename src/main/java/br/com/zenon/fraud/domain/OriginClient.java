package br.com.zenon.fraud.domain;

import java.math.BigDecimal;

public record OriginClient(String nameOrig,
                           BigDecimal oldbalanceOrg,
                           BigDecimal newbalanceOrig) {
}
