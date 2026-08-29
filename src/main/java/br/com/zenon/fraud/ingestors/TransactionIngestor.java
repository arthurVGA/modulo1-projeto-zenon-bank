package br.com.zenon.fraud.ingestors;

import br.com.zenon.fraud.domain.Transaction;
import br.com.zenon.fraud.mappers.TransactionMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TransactionIngestor {
    private static final String FILE_NAME = "PS_20174392719_1491204439457_log.csv";
    private final TransactionMapper mapper;

    public TransactionIngestor(TransactionMapper mapper) {
        this.mapper = mapper;
    }

    protected Path findFile() {
        try {
            return Path.of(
                    Objects.requireNonNull(
                                    getClass()
                                            .getClassLoader()
                                            .getResource(FILE_NAME)
                            )
                            .toURI()
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException("Problema ao tentar achar o arquivo");
        }
    }

    public List<Transaction> readLines(int maxLines) {
        Path file = findFile();
        List<Transaction> transactions = new ArrayList<>();

        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            for (int counter = 0; counter <= maxLines; counter++) {
                String line = reader.readLine();
                if (line.startsWith("step")) {
                    continue;
                }
                transactions.add(mapper.map(line.split(",")));
            }
            return transactions;
        } catch (IOException e) {
            throw new RuntimeException("Problema de I/O ao tentar ler o arquivo");
        }
    }

}
