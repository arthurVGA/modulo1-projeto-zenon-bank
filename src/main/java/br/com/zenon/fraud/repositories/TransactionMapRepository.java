package br.com.zenon.fraud.repositories;

import br.com.zenon.fraud.domain.Transaction;
import br.com.zenon.fraud.utils.BenchmarkUtil;
import br.com.zenon.fraud.utils.FileUtils;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TransactionMapRepository implements TransactionRepository {
    private final Path file;
    private Map<String, Transaction> fileLines;

    public TransactionMapRepository(String filename) {
        this.file = FileUtils.findFile(filename);
    }

    public void readBenchmark() {
        var start = System.nanoTime();
        readFile();
        var end = System.nanoTime();

        BenchmarkUtil.showResultFormatted("Tempo da leitura do arquivo - Map: ", (end - start));
    }

    public void searchBenchmark(String nameOriginClient) {
        var start = System.nanoTime();
        findByNameOriginClient(nameOriginClient);
        var end = System.nanoTime();

        BenchmarkUtil.showResultFormatted("Tempo da pesquisa - Map: ", (end - start));
    }

    protected void findByNameOriginClient(String nameOrig) {
        var transaction = fileLines.get(nameOrig);
        if (transaction != null) {
            System.out.println(transaction);
        }
    }

    protected void readFile() {
        try (BufferedReader br = Files.newBufferedReader(file)) {
            this.fileLines = readLines(br);
        } catch (Exception e) {
            throw new RuntimeException("Problema de I/O ao tentar ler o arquivo");
        }
    }

    protected Map<String, Transaction> readLines(BufferedReader br) throws Exception {
        Map<String, Transaction> lines = new HashMap<>();
        while (br.readLine() != null) {
            var line = br.readLine();
            if (line != null && !line.startsWith("step")) {
                putMappedLine(line, lines);
            }
        }

        return lines;
    }

    protected void putMappedLine(String line, Map<String, Transaction> lines) throws Exception {
        String[] columns = line.split(",");
        lines.put(columns[3],
                new Transaction(
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
                )
        );
    }
}
