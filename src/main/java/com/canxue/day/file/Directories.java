package com.canxue.day.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Lishuntao
 * @Date 2019/10/25
 */
public class Directories {
    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }

    static void refreshTestDir() throws Exception {
        String s = test.toAbsolutePath().toString();
        System.out.println(s);
        if (Files.exists(test))
            RmDir.rmdir(test);
        if (!Files.exists(test))
            Files.createDirectory(test);
    }

    public static void main(String[] args) throws Exception {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();
        try {
            Files.createDirectory(variant);
        } catch (Exception e) {
            System.out.println("con't create new file");
        }
        populateTestDir();
        Path tempdir = Files.createTempDirectory(test, "DIR_");
        Files.createTempFile(tempdir, "pre", ".non");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("*********");
        Files.walk(test).forEach(System.out::println);

    }

    static void populateTestDir() throws IOException {

        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();

            if (!Files.exists(variant)) {
                Files.createDirectories(variant);
                Path path = Paths.get("D:\\myproject\\javathink\\src\\main\\java\\com\\canxue\\day\\file\\Directories.java").normalize();
                Files.copy(path, variant.resolve("File.txt"));
                Files.createTempFile(variant, null, null);
            }

        }

    }

    @Test
    void sayPath() {


    }

}
