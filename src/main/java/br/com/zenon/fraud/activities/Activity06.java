package br.com.zenon.fraud.activities;

import br.com.zenon.fraud.repositories.TransactionListRepository;
import br.com.zenon.fraud.repositories.TransactionMapRepository;
import br.com.zenon.fraud.repositories.TransactionRepository;

public class Activity06 {
    static void main() {
        System.out.println("----------------------------------------------------------");
        System.out.println("ATIVIDADE 06");
        System.out.println("----------------------------------------------------------");

        TransactionRepository repository;
        String filename = "data/PS_20174392719_1491204439457_log.csv";

        repository = new TransactionListRepository(filename);
        repository.readBenchmark();
        repository.searchBenchmark("C1868032458");

        System.out.println();

        repository = new TransactionMapRepository(filename);
        repository.readBenchmark();
        repository.searchBenchmark("C1868032458");
    }
}
