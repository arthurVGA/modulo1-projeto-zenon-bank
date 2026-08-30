package br.com.zenon;

import br.com.zenon.fraud.mappers.TransactionMapper;
import br.com.zenon.fraud.repositories.TransactionListRepository;
import br.com.zenon.fraud.repositories.TransactionMapRepository;
import br.com.zenon.fraud.repositories.TransactionRepository;

public class Application {

    static void main() {
        TransactionRepository repository;
        String filename = "data/PS_20174392719_1491204439457_log.csv";
        TransactionMapper mapper = new TransactionMapper();

        System.out.println("----------------------------------------------------------");
        repository = new TransactionListRepository(filename, mapper);
        repository.readBenchmark();
        repository.searchBenchmark("C1868032458");

        System.out.println("----------------------------------------------------------");

        repository = new TransactionMapRepository(filename, mapper);
        repository.readBenchmark();
        repository.searchBenchmark("C1868032458");

        System.out.println("----------------------------------------------------------");
    }
}
