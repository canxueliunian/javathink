package com.canxue.day.self;

/**
 * @Author Lishuntao
 * @Date 2019/10/11
 */

import java.util.function.Consumer;
import java.util.function.IntToLongFunction;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

public class FunctionalAnnotation {
    public String goodbye(String arg) {
        return "Goodbye, " + arg;
    }

    public static void main(String[] args) {

        FunctionalAnnotation fa = new FunctionalAnnotation();
        FunctionalNoAnn fna = fa::goodbye;
        Functional f = fa::goodbye;

        Functional fl=arg -> "Goodbye"+arg;
        Consumer<String> consumer=arg -> System.out.println("goodle"+arg);
        Consumer<String> consumer2= System.out::println;
        IntToLongFunction d =arg->arg/2+2111L;
        long l = d.applyAsLong(12);
        System.out.println(l);


    }
}
