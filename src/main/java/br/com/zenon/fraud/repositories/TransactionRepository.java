package br.com.zenon.fraud.repositories;

public interface TransactionRepository {
    void readBenchmark();

    void searchBenchmark(String nameOriginClient);
}
