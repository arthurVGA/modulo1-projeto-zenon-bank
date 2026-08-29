package br.com.zenon.fraud.mappers;

import br.com.zenon.fraud.domain.DestinyClient;
import br.com.zenon.fraud.domain.OriginClient;
import br.com.zenon.fraud.domain.Transaction;
import br.com.zenon.fraud.domain.TransactionType;

import java.math.BigDecimal;

public class TransactionMapper {

    public Transaction map(String[] columns) {
        return new Transaction(
                Integer.parseInt(columns[0]),
                TransactionType.valueOf(columns[1]),
                new BigDecimal(columns[2]),
                mapOriginClient(columns[3], columns[4], columns[5]),
                mapDestinyClient(columns[6], columns[7], columns[8]),
                columns[9].equals("1"),
                columns[10].equals("1")
        );
    }

    protected OriginClient mapOriginClient(String nameOrig, String oldBalance, String newBalance) {
        return new OriginClient(
                nameOrig,
                new BigDecimal(oldBalance),
                new BigDecimal(newBalance)
        );
    }

    protected DestinyClient mapDestinyClient(String nameDestiny, String oldBalance, String newBalance) {
        return new DestinyClient(
                nameDestiny,
                new BigDecimal(oldBalance),
                new BigDecimal(newBalance)
        );
    }
}
