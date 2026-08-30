package br.com.zenon.fraud.repositories;

import br.com.zenon.fraud.domain.Transaction;
import br.com.zenon.fraud.mappers.TransactionMapper;
import br.com.zenon.fraud.utils.BenchmarkUtil;
import br.com.zenon.fraud.utils.FileUtils;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionListRepository implements TransactionRepository {
    private final Path file;
    private final TransactionMapper mapper;
    private List<Transaction> fileLines;

    public TransactionListRepository(String filename, TransactionMapper mapper) {
        this.file = FileUtils.findFile(filename);
        this.mapper = mapper;
    }

    public void readBenchmark() {
        var start = System.nanoTime();
        this.readFile();
        var end = System.nanoTime();

        BenchmarkUtil.showResultFormatted("Tempo da leitura do arquivo - List: ", (end - start));
    }

    public void searchBenchmark(String nameOriginClient) {
        var start = System.nanoTime();
        this.findByNameOriginClient(nameOriginClient);
        var end = System.nanoTime();

        BenchmarkUtil.showResultFormatted("Tempo da pesquisa - List: ", (end - start));
    }

    protected void findByNameOriginClient(String nameOrig) {
        for (Transaction line : fileLines) {
            if (line.getOriginClient().getNameOrig().equals(nameOrig)) {
                System.out.println(line);
                break;
            }
        }
    }

    protected void readFile() {
        try (BufferedReader br = Files.newBufferedReader(file)) {
            this.fileLines = readLines(br);
        } catch (Exception e) {
            throw new RuntimeException("Problema de I/O ao tentar ler o arquivo");
        }
    }

    protected List<Transaction> readLines(BufferedReader br) throws Exception {
        List<Transaction> lines = new ArrayList<>();
        while (br.readLine() != null) {
            var line = br.readLine();
            if (line != null && !line.startsWith("step")) {
                addMappedLine(line, lines);
            }
        }

        return lines;
    }

    protected void addMappedLine(String line, List<Transaction> lines) throws Exception {
        String[] columns = line.split(",");
        var lineMapped = mapper.map(columns);
        lines.add(lineMapped);
    }

}
