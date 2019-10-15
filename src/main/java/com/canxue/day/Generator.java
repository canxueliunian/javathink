package com.canxue.day;

import com.sun.org.apache.xpath.internal.operations.Operation;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @Author Lishuntao
 * @Date 2019/10/14
 */
public class Generator {
    @Data
    static class People {
        private String name;

        static People show(String name) {
            return new People(name);
        }

        public People(String name) {
            this.name = name;
        }
    }

    Random rand = new Random(47);
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public String get() {
        return "" + letters[rand.nextInt(letters.length)];
    }

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        Arrays.stream(new double[]{
                3.12, 2.14, 1.76
        }).forEach(n -> System.out.format("%d", n));
        Comparator.reverseOrder();


    }


}
