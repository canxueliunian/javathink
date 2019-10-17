package com.canxue.day.optional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author Lishuntao
 * @Date 2019/10/16
 */
public class OptionalBasics {

    static void test(Optional<String> optionalS) {
        if (optionalS.isPresent()) {
            System.out.println(optionalS.get());

        } else {
            System.out.println(" nothing  inside");
        }

    }


    public static void main(String[] args) {
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String >empty().findFirst());

    }


}
