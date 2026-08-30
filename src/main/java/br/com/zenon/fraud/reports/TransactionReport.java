package br.com.zenon.fraud.reports;

import br.com.zenon.fraud.domain.Transaction;
import br.com.zenon.fraud.utils.FileUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class TransactionReport {
    private final Path file;

    public TransactionReport(String filename) {
        this.file = FileUtils.findFile(filename);
    }

    public long getCount() {
        try (Stream<String> lines = Files.lines(file)) {
            return lines
                    .filter(l -> !l.startsWith("step"))
                    .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long getCountFraud() {
        try (Stream<String> lines = Files.lines(file)) {
            return lines
                    .filter(l -> !l.startsWith("step"))
                    .map(l -> {
                            String[] columns = l.split(",");
                            return Integer.parseInt(columns[9]) == 1;
                        }
                    )
                    .filter(f -> f)
                    .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BigDecimal getTotalAmount() {
        try (Stream<String> lines = Files.lines(file)) {
            return lines
                    .filter(l -> !l.startsWith("step"))
                    .map(l -> {
                                String[] columns = l.split(",");
                                return new BigDecimal(columns[2]);
                            }
                    )
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
