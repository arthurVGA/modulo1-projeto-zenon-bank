package br.com.zenon.fraud.analyzers;

import br.com.zenon.fraud.domain.Transaction;
import br.com.zenon.fraud.ingestors.TransactionIngestor;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FraudAnalyzer {
    private final TransactionIngestor ingestor;

    public FraudAnalyzer(TransactionIngestor ingestor) {
        this.ingestor = ingestor;
    }

    public void analyzeTransactions() {
        var transactions = ingestor
                .readFile()
                .stream()
                .filter(Transaction::isFraud)
                .sorted(Comparator
                        .comparing(Transaction::getAmount)
                        .reversed()
                )
                .toList();

        showAmountOfFraud(transactions);
        showThreeBiggestFrauds(transactions);
        showSuspectedClient(transactions);
        showTotalOfPrejudice(transactions);
        showAmountOfFraudPerType(transactions);
    }

    protected void showAmountOfFraud(List<Transaction> transactions) {
        var amountOfFraud = transactions.size();
        System.out.println("1. Total de Fraudes: " + amountOfFraud);
    }

    protected void showThreeBiggestFrauds(List<Transaction> transactions) {
        System.out.println("2. Top 3 Fraudes de Maior Valor:");
        transactions
                .subList(0, 3)
                .stream()
                .map(Transaction::getAmount)
                .map(BigDecimal::toPlainString)
                .forEach(System.out::println);
    }

    protected void showSuspectedClient(List<Transaction> transactions) {
        System.out.println("3. Clientes Suspeitos: ");
        transactions
                .stream()
                .map(t -> t.getOriginClient().getNameOrig())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    protected void showTotalOfPrejudice(List<Transaction> transactions) {
        var amountDefrauded = transactions
                .stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("4. Prejuízo Total: " + amountDefrauded);
    }

    protected void showAmountOfFraudPerType(List<Transaction> transactions) {
        var groupedByType = transactions
                .stream()
                .collect(Collectors.groupingBy(t -> t.getType().name(), Collectors.counting()));

        System.out.println("5. Fraudes por Tipo: ");
        groupedByType.forEach((type, count) -> System.out.println(type +": " + count));
    }
}
