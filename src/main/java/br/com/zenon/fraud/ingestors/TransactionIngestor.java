package br.com.zenon.fraud.ingestors;

import br.com.zenon.fraud.mappers.TransactionMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class TransactionIngestor {
    private final TransactionMapper mapper;

    public TransactionIngestor(TransactionMapper mapper) {
        this.mapper = mapper;
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

    public void showLines(String filename) {
        Path file = findFile(filename);

        try (
                InputStream in = Files.newInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))
        ) {
            do {
                String line = reader.readLine();

                if (line != null && line.startsWith("step")) {
                    continue;
                }

                showLine(line);
            } while (reader.readLine() != null);
        } catch (IOException e) {
            throw new RuntimeException("Problema de I/O ao tentar ler o arquivo");
        }
    }

    protected void showLine(String line) {
        try {
            String[] columns = line.split(",");
            System.out.println(mapper.map(columns));
        } catch (Exception e) {
            System.err.println("Erro: " + line);
        }
    }
}
