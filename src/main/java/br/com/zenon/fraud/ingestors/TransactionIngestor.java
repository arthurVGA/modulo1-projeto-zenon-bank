package br.com.zenon.fraud.ingestors;

import br.com.zenon.fraud.domain.Transaction;
import br.com.zenon.fraud.utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionIngestor {
    private final Path file;

    public TransactionIngestor(String filename) {
        this.file = FileUtils.findFile(filename);
    }

    public List<Transaction> read1000Lines()  {
        String line;
        List<Transaction> linesMapped = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(file)) {
            while ((line = br.readLine()) != null && linesMapped.size() < 1000) {
                addMappedLine(line, linesMapped);
            }
            return linesMapped;
        } catch (IOException e) {
            throw new RuntimeException("Problema de I/O ao tentar ler o arquivo");
        }
    }

    public List<Transaction> readFile() {
        String line;
        List<Transaction> linesMapped = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(file)) {

            while ((line = br.readLine())  != null) {
                addMappedLine(line, linesMapped);
            }

            return linesMapped;
        } catch (IOException e) {
            throw new RuntimeException("Problema de I/O ao tentar ler o arquivo");
        }
    }

    protected void addMappedLine(String line, List<Transaction> linesMapped) throws IOException {
        if (line != null && !line.startsWith("step")) {
            var lineMapped = mapLine(line);

            if (lineMapped != null) {
                linesMapped.add(lineMapped);
            }
        }
    }

    protected Transaction mapLine(String line) {
        String[] columns = line.split(",");
        try {
            return new Transaction(
                    Integer.parseInt(columns[0]),
                    columns[1],
                    new BigDecimal(columns[2]),
                    columns[3],
                    new BigDecimal(columns[4]),
                    new BigDecimal(columns[5]),
                    columns[6],
                    new BigDecimal(columns[7]),
                    new BigDecimal(columns[8]),
                    Integer.parseInt(columns[9]),
                    Integer.parseInt(columns[10])
            );
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + line);
            return null;
        }
    }
}
