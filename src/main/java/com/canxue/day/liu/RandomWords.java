package com.canxue.day.liu;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Lishuntao
 * @Date 2019/10/15
 */
public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    RandomWords(String fname) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fname));
        // 略过第一行
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+"))
                words.add(word.toLowerCase());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return words.stream().collect(Collectors.joining(" "));
    }

    @Override
        public String get () {
            return words.get(rand.nextInt(words.size()));
        }


    public static void main(String[] args) throws IOException {
        URL path = RandomWords.class.getClassLoader().getResource("Cheese.dat");
        String file = path.getFile();
        file="D:/myproject/javathink/target/classes/Cheese.dat";
        System.out.println(file);
        System.out.println(

                Stream.generate(new RandomWords(file)).
                        limit(10).
                        collect(Collectors.joining(" "))
        );


        Random random = new Random(47);
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }


    }
