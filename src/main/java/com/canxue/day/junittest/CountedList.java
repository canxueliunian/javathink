package com.canxue.day.junittest;

import java.util.ArrayList;

/**
 * @Author Lishuntao
 * @Date 2019/10/22
 */
public class CountedList extends ArrayList<String> {
    private static int counter = 0;
    private int id = counter++;

    public CountedList() {
        System.out.println("CountedList #" + id);
    }

    public int getId() {
        return id;
    }
}
