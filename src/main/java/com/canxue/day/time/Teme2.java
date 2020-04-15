package com.canxue.day.time;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.canxue.day.LocalDateUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import java.time.LocalDateTime;

/**
 * @Author Lishuntao
 * @Date 2019/10/17
 * json 与localdatetime的转换处理
 */
public class Teme2 {
    private static Logger logger = Logger.getLogger("Teme2");

    @Test
    public void bu() {
        Short s = 2;
        System.out.println(s.equals(2));
        Integer i = 2;
        System.out.println(i.equals(2));
        int is = 2;
        System.out.println(s.equals((short) 2));

    }


    private void addList(List<String> s) {
        s.add("d");
    }

    public static Integer DEAL_NUM = 3;

    public void add(String a) {
        Integer integer = Integer.valueOf(a);
        Integer s = integer + 5;
        a = s + "";
    }

    public void add(Integer a) {
        Integer s = a + 5;
        a = s;

    }

    public <T> List<List<T>> buildSubtask(List<T> todb) {
        List<List<T>> dataLists = new ArrayList<>();
        if (todb.size() == 0) {
            return dataLists;
        }
        int trueSize = todb.size();
        int size = todb.size();
        int start = 0;
        int end = DEAL_NUM;
        while (size > DEAL_NUM) {
            List<T> toList = todb.subList(start, end);
            dataLists.add(toList);
            size = size - DEAL_NUM;
            start = start + DEAL_NUM;
            end = end + DEAL_NUM;
        }
        List<T> toList = todb.subList(trueSize - size, trueSize);
        dataLists.add(toList);
        return dataLists;
    }

}
