package br.com.zenon.fraud.activities;

import br.com.zenon.fraud.domain.Transaction;

import java.math.BigDecimal;

public class Activity02 {
    static void main() {
        System.out.println("----------------------------------------------------------");
        System.out.println("ATIVIDADE 02");
        System.out.println("----------------------------------------------------------");

        System.out.println(
            buildTransaction(
                1, "PAYMENT", "9839.64", "C1231006815", "170136.0",
                "160296.36", "M1979787155", "0.0", "0.0", 0, 0
            )
        );

        System.out.println(
            buildTransaction(
                743,"CASH_OUT", "850002.52", "C1280323807", "850002.52",
                "0.0", "C873221189", "6510099.11", "7360101.63", 1, 0
            )
        );
    }

    private static Transaction buildTransaction(int step,
                                                String type,
                                                String amount,
                                                String nameOrig,
                                                String oldBalanceOrg,
                                                String newBalanceOrig,
                                                String nameDest,
                                                String oldBalanceDest,
                                                String newBalanceDest,
                                                Integer isFraud,
                                                Integer isFlaggedFraud) {
        return new Transaction(
                step,
                type,
                new BigDecimal(amount),
                nameOrig,
                new BigDecimal(oldBalanceOrg),
                new BigDecimal(newBalanceOrig),
                nameDest,
                new BigDecimal(oldBalanceDest),
                new BigDecimal(newBalanceDest),
                isFraud,
                isFlaggedFraud
        );
    }
}
