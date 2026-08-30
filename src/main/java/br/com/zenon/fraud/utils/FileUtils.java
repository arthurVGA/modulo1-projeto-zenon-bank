package br.com.zenon.fraud.utils;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

public class FileUtils {
    public static Path findFile(String filename) {
        try {
            return Path.of(
                    Objects.requireNonNull(
                                    FileUtils.class
                                            .getClassLoader()
                                            .getResource(filename)
                            )
                            .toURI()
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException("Problema ao tentar achar o arquivo");
        }
    }
}
