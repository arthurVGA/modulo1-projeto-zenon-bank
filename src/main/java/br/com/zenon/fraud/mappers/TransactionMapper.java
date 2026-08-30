package br.com.zenon.fraud.mappers;

import br.com.zenon.fraud.domain.Transaction;

import java.math.BigDecimal;

public class TransactionMapper {

    public Transaction map(String[] columns) throws Exception {
        return new Transaction(
                Integer.parseInt(columns[0]),
                columns[1],
                new BigDecimal(columns[2]),
                columns[3],
                new BigDecimal(columns[4]),
                new BigDecimal(columns[5]),
                columns[6],
                new BigDecimal(columns[7]),
                new BigDecimal(columns[8]),
                Integer.parseInt(columns[9]),
                Integer.parseInt(columns[10])
        );
    }
}
