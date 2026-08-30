package br.com.zenon.fraud.utils;

import java.time.Duration;

public class BenchmarkUtil {
    public static void showResultFormatted(String message, long nanoDuration) {
        Duration duration = java.time.Duration.ofNanos(nanoDuration);

        long seconds = duration.toSecondsPart();
        long millis = duration.toMillisPart();
        long nano = duration.toNanosPart();
        String readableTime = String.format("%02d.%03d.%03d", seconds, millis, nano);
        System.out.println(message + readableTime);
    }
}
