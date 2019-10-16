package com.canxue.day.liu;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author canxue
 * @create2019-10-15-22:56
 */
public class Machine2 {
    private String all;

    public Stream<String> stream() {
        return Pattern.compile("[.,?]]+").splitAsStream(all);
    }

    public static void main(String[] args) {

        Arrays.stream(new int[]{
                3, 4, 5, 7
        }, 3, 5).map(a -> a + 4).forEach(System.out::println);


    }

}
