package com.canxue.day.optional;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author Lishuntao
 * @Date 2019/10/16
 */
public class OptionalsFromEmptyStreams {


    public static void main(String[] args) {
        System.out.println(
                Stream.<String>empty().findFirst()

        );
        System.out.println(Stream.<String>empty()
                .findAny());



        System.out.println(Stream.<String>empty()
                .min(String.CASE_INSENSITIVE_ORDER));

        System.out.println(Stream.<String>empty()
                .reduce((s1, s2) -> s1 + s2));
        System.out.println(IntStream.empty()
                .average());
    }




}
