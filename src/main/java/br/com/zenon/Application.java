package br.com.zenon;

import br.com.zenon.fraud.analyzers.FraudAnalyzer;
import br.com.zenon.fraud.domain.Transaction;
import br.com.zenon.fraud.ingestors.TransactionIngestor;
import br.com.zenon.fraud.mappers.TransactionMapper;

import java.util.List;

public class Application {
    static void main() {
        String filename = "data/PS_20174392719_1491204439457_log.csv";
        TransactionMapper mapper = new TransactionMapper();
        TransactionIngestor ingestor = new TransactionIngestor(filename, mapper);
        FraudAnalyzer fraudAnalyzer = new FraudAnalyzer(ingestor);

        fraudAnalyzer.analyzeTransactions();
    }
}
