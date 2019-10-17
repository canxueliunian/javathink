package com.canxue.day.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author Lishuntao
 * @Date 2019/10/16
 */
public class Frobnitz {
    int size;

    Frobnitz(int sz) {
        size = sz;
    }

    @Override
    public String toString() {
        return "Frobnitz(" + size + ")";
    }

    // Generator:
    static Random rand = new Random(47);
    static final int BOUND = 100;

    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }

    interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {
    }

    static void show(Matcher match, int val) {
        match.test(IntStream.rangeClosed(1, 9).boxed().peek(n -> System.out.println(n))
                , n -> n < val
        );
    }

    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply).limit(10).peek(System.out::println).
                reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1).ifPresent(System.out::println);
        List list = new ArrayList<>();
        show(Stream::allMatch,10);

    }
}
