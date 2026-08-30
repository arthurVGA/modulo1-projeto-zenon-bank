package br.com.zenon;

import br.com.zenon.fraud.ingestors.TransactionIngestor;
import br.com.zenon.fraud.mappers.TransactionMapper;

public class Application {
    static void main() {
        String filename = "data/paysim_with_bad_data.csv";
        TransactionMapper mapper = new TransactionMapper();
        TransactionIngestor ingestor = new TransactionIngestor(mapper);

        ingestor.showLines(filename);
    }
}
