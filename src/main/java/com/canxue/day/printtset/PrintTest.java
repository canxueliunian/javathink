package com.canxue.day.printtset;

import lombok.Data;

import java.util.Formatter;

/**
 * @Author Lishuntao
 * @Date 2019/10/31
 */
@Data
public class PrintTest {
    private Formatter f = new Formatter(System.out);
    private String name;

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)%n",
                name, x, y);
    }

    public static void main(String[] args) {

        System.out.printf("Row1: [%d %10.3f] %n", 5, 3.45d);
        System.out.format("Row1: [%d %f ] %n", 5, 3.45d);
        PrintTest printTest = new PrintTest();
        printTest.setName("232");
        printTest.move(2, 3);

        String format = String.format("this is a %1$s,that is a %2$s","he","ss");
        System.out.println(format);
    }
}
