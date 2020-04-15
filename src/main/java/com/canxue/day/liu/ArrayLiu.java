package com.canxue.day.liu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author Lishuntao
 * @Date 2019/11/15
 */
public class ArrayLiu {


    public static void main(String[] args) {

    }

    @Test
    public void test01() {

        String[] strings = new String[10];
        Arrays.setAll(strings, n -> "new" + n);
        Arrays.stream(strings).skip(3).limit(5).
                map(ss -> ss + "!").forEach(System.out::println);
        Arrays.sort(strings);
        int new8 = Arrays.binarySearch(strings, "new8");
        System.out.println(new8);

    }

}
