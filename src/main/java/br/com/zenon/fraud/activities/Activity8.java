package br.com.zenon.fraud.activities;

import br.com.zenon.fraud.reports.TransactionReport;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Activity8 {
    static void main() {
        String filename = "data/PS_20174392719_1491204439457_log.csv";
        TransactionReport report = new TransactionReport(filename);

        long totalOfLines = report.getCount();
        long totalOfFrauds = report.getCountFraud();
        BigDecimal amount = report.getTotalAmount();

        showReports(totalOfLines, totalOfFrauds, amount, Locale.US);
        showReports(totalOfLines, totalOfFrauds, amount, Locale.of("pt", "BR"));
    }

    private static void showReports(long totalOfLines, long totalOfFrauds, BigDecimal amount, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("report", locale);

        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        currencyFormat.setMaximumFractionDigits(2);
        currencyFormat.setMinimumFractionDigits(2);

        System.out.println("----------------------------------------------------------");
        System.out.println(bundle.getString("activity"));
        System.out.println("----------------------------------------------------------");

        System.out.println(bundle.getString("lines") + " " + numberFormat.format(totalOfLines));
        System.out.println(bundle.getString("frauds") + " " + numberFormat.format(totalOfFrauds));
        System.out.println(bundle.getString("value") + " " + currencyFormat.format(amount));
    }

}
