package br.com.zenon.fraud.domain;

import java.math.BigDecimal;

public record Transaction(int step, TransactionType type, BigDecimal amount, OriginClient originClient, DestinyClient destinyClient, int isFraud, int isFlaggedFraud) {
}
