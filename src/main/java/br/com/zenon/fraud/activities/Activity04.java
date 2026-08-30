package br.com.zenon.fraud.activities;

import br.com.zenon.fraud.domain.Transaction;
import br.com.zenon.fraud.ingestors.TransactionIngestor;

public class Activity04 {
    static void main() {
        System.out.println("----------------------------------------------------------");
        System.out.println("ATIVIDADE 04");
        System.out.println("----------------------------------------------------------");

        String filenameWithError = "data/paysim_with_bad_data.csv";
        var ingestor = new TransactionIngestor(filenameWithError);

        var lines = ingestor.readFile();

        for (Transaction line : lines){
            System.out.println(line);
        }
    }    
}
