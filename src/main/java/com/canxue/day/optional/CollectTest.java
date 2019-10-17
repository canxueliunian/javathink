package com.canxue.day.optional;

import java.lang.reflect.Field;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @Author Lishuntao
 * @Date 2019/10/16
 */
public class CollectTest {

    public static void main(String[] args) throws Exception {
        URL resource = CollectTest.class.getClassLoader().getResource("");
        String path = resource.getPath();
        System.out.println(path);
        path = "D:/myproject/javathink/src/main/java/com/canxue/day/optional/CollectTest.java";
    Set<String> words = Files.lines(Paths.get(path)).
                flatMap(s -> Arrays.stream(s.split("\\W+"))).filter(s -> !s.matches("\\d+"))
                .map(String::trim)
                .filter(s -> s.length() > 2).limit(100).
                collect(Collectors.toCollection(TreeSet::new));
        System.out.println(words);
    }
}
