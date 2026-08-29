package br.com.zenon;

import br.com.zenon.fraud.ingestors.TransactionIngestor;
import br.com.zenon.fraud.mappers.TransactionMapper;

public class Application {
    static void main() {
        TransactionMapper mapper = new TransactionMapper();
        TransactionIngestor ingestor = new TransactionIngestor(mapper);

        ingestor
                .readLines(10)
                .forEach(System.out::println);
    }
}
