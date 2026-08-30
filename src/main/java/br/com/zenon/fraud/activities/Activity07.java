package br.com.zenon.fraud.activities;

import br.com.zenon.fraud.reports.TransactionReport;

public class Activity07 {
    static void main() {
        System.out.println("----------------------------------------------------------");
        System.out.println("ATIVIDADE 07");
        System.out.println("----------------------------------------------------------");

        String filename = "data/PS_20174392719_1491204439457_log.csv";
        TransactionReport report = new TransactionReport(filename);

        System.out.println("Total de linhas: " + report.getCount());
        System.out.println("Total de fraudes: " + report.getCountFraud());
        System.out.println("Valor total transacionado: " + report.getTotalAmount());
    }
}
