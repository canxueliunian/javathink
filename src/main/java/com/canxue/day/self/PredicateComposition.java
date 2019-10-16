package com.canxue.day.self;


import sun.nio.cs.Surrogate;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * @Author Lishuntao
 * @Date 2019/10/12
 */
public class PredicateComposition {



    public static void main(String[] args) {


        new Random(47).ints(5,20).
                distinct().limit(7).boxed()
                .forEach(System.out::println);





    }

}
