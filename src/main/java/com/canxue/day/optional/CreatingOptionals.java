package com.canxue.day.optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Author Lishuntao
 * @Date 2019/10/16
 */
public class CreatingOptionals {

//    static void test(String testName , Optional<String > opt){
//        System.out.println("===="+testName +"====");
//        System.out.println(opt.orElse("NULL"));
//    }


    static String[] elements = {
            "Foo", "", "Bar", "Baz", "Bingo"
    };
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }
    static void test(String descr, Predicate<String> pred) {
        System.out.println(" ---( " + descr + " )---");
        for(int i = 0; i <= elements.length; i++) {
            System.out.println(
                    testStream()
                            .skip(i)
                            .findFirst()
                            .filter(pred));
        }
    }
    public static void main(String[] args) {
        test("true", str -> true);
        test("false", str -> false);
        test("str != \"\"", str -> str != "");
        test("str.length() == 3", str -> str.length() == 3);
        test("startsWith(\"B\")",
                str -> str.startsWith("B"));
        new Random().ints(3,6).
                forEachOrdered(n-> System.out.println());
    }


}
