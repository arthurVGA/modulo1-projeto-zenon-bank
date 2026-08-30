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
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class TransactionIngestor {
    private final String filename;
    private final TransactionMapper mapper;

    public TransactionIngestor(String filename, TransactionMapper mapper) {
        this.filename = filename;
        this.mapper = mapper;
    }

    public void showLines() {
        readLines()
                .forEach(System.out::println);
    }

    public List<Transaction> readLines() {
        Path file = findFile(filename);

        try (Stream<String> lines = Files.lines(file)) {
            return lines
                    .filter(line -> line.startsWith("step"))
                    .map(this::mapLine)
                    .filter(Objects::nonNull)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Problema de I/O ao tentar ler o arquivo");
        }
    }

    protected Path findFile(String filename) {
        try {
            return Path.of(
                    Objects.requireNonNull(
                                    getClass()
                                            .getClassLoader()
                                            .getResource(filename)
                            )
                            .toURI()
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException("Problema ao tentar achar o arquivo");
        }
    }

    protected Transaction mapLine(String line) {
        try {
            String[] columns = line.split(",");
            return mapper.map(columns);
        } catch (Exception e) {
            System.err.println("Erro: " + line);
            return null;
        }
    }
}
