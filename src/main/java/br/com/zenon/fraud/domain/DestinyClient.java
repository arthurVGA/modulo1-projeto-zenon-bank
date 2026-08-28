package br.com.zenon.fraud.domain;

import java.math.BigDecimal;

public record DestinyClient(String nameDest,
                            BigDecimal oldbalanceDest,
                            BigDecimal newbalanceDest) {
}
