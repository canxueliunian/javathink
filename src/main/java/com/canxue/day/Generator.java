package com.canxue.day;

import com.sun.org.apache.xpath.internal.operations.Operation;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Lishuntao
 * @Date 2019/10/14
 */
public class Generator implements Supplier<String> {
    Random rand = new Random(47);
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public String get() {
        String d= "" + letters[rand.nextInt(letters.length)];
        System.out.println(d);
        return d;
    }

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        String collect = Stream.generate(new Generator()).limit(30).collect(Collectors.joining());
        System.out.println(collect);


    }


}
