package br.com.zenon.fraud.activities;

import br.com.zenon.fraud.analyzers.FraudAnalyzer;
import br.com.zenon.fraud.ingestors.TransactionIngestor;

public class Activity05 {
    static void main() {
        System.out.println("----------------------------------------------------------");
        System.out.println("ATIVIDADE 05");
        System.out.println("----------------------------------------------------------");
        analyze_05();
        System.out.println("----------------------------------------------------------\n");
    }

    private static void analyze_05() {
        String filename = "data/PS_20174392719_1491204439457_log.csv";
        var ingestor = new TransactionIngestor(filename);
        var fraudAnalyzer = new FraudAnalyzer(ingestor);

        fraudAnalyzer.analyzeTransactions();
    }
}
