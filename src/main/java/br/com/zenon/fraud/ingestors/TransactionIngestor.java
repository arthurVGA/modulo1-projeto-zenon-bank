package br.com.zenon.fraud.ingestors;

import br.com.zenon.fraud.domain.Transaction;
import br.com.zenon.fraud.mappers.TransactionMapper;
import br.com.zenon.fraud.utils.FileUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class TransactionIngestor {
    private final Path file;
    private final TransactionMapper mapper;

    public TransactionIngestor(String filename, TransactionMapper mapper) {
        this.file = FileUtils.findFile(filename);
        this.mapper = mapper;
    }

    public List<Transaction> readFile() {
        try (Stream<String> lines = Files.lines(file)) {
            return lines
                        .map(this::mapLine)
                        .toList();
        } catch (Exception e) {
            throw new RuntimeException("Problema de I/O ao tentar ler o arquivo");
        }
    }

    protected Transaction mapLine(String line) {
        String[] columns = line.split(",");
        try {
            return mapper.map(columns);
        } catch (Exception e) {
            System.err.println("Erro: " + line);
            throw new RuntimeException(e);
        }
    }
}
