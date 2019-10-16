package com.canxue.day.liu;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Author Lishuntao
 * @Date 2019/10/15
 */
public class Randoms {

    public static void main(String[] args) {
        new Random(47).ints(5, 20).
                distinct().limit(7).sorted().forEach(System.out::println);
        Stream.of(new Bubble(1), new Bubble(2), new Bubble(3)).forEach(System.out::println);
        List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));
        int sum = bubbles.stream().mapToInt(Bubble::getName).sum();
        System.out.println(sum);

    }
}
