package br.com.zenon.fraud.activities;

import br.com.zenon.fraud.ingestors.TransactionIngestor;

public class Activity03 {
    static void main() {
        System.out.println("----------------------------------------------------------");
        System.out.println("ATIVIDADE 03");
        System.out.println("----------------------------------------------------------");

        var filename = "data/PS_20174392719_1491204439457_log.csv";
        var ingestor = new TransactionIngestor(filename);

        var lines = ingestor.read1000Lines();

        for (int count = 0; count < 10; count++){
            System.out.println(lines.get(count));
        }
    }

}
