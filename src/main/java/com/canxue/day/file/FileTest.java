package com.canxue.day.file;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;


/**
 * @Author Lishuntao
 * @Date 2019/10/24
 */
public class FileTest {


    @Test
    public void formatterTest() {
        // 使用 format进行格式化输出
        System.out.printf("this is a String: %s , this is a number: %.2f", "test", 4.56f);
        System.out.format("this is a String: %s , this is a number: %.2f", "test", 4.56f);

        // %[argument_index$][flags][width]conversion
        System.out.println();
        double d1 = 34.34;
        double d2 = 34.3445;
        System.out.printf("d1: %2$6.2f  , and d2 : %1$09.6f", d1, d2);  // 使用第一个参数总共9位,保留6位小数, 空余位使用0进行填充
    }

    public static final List<String> OutTaskTypes = new ArrayList<String>() {
        {
            add("wajTask");
            add("ismsTask");
            add("drmsTask");
        }
    };

    @Test
    public void messageFormatTest() {

        MessageFormat messageFormat = new MessageFormat("this is message: {0} , this is a number {1,number,##.##}");
        Object[] array = new Object[]{
                "测试", 425.67333
        };
        String format = messageFormat.format(array);
        MessageFormat.format("this is a number {0}", "test");
        System.out.println(format);
    }

    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);
        formatter.format("this is a String: %s , this is a number: %10.2f", "test", 4.56f);
    }

    @Test
    public void listTest() {


        List<List> dataList = new ArrayList<List>();
        List<People> peopleList = new ArrayList<People>();
        People people = new People();
        people.setName("小黄");
        People people2 = new People();
        people2.setName("小明");
        peopleList.add(people2);
        peopleList.add(people);
        for (People p : peopleList) {
            List<String> l = new ArrayList<>();
            l.add(p.getName());
            dataList.add(l);
        }
        System.out.println(dataList);
        System.out.println();
        dataList.clear();
        List<String> l = new ArrayList<>();
        for (People p : peopleList) {
            l.add(p.getName());
            dataList.add(l);
        }
        System.out.println(dataList);
        System.out.println();
        dataList.clear();
        l.clear();
        for (People p : peopleList) {
            l.add(p.getName());
            dataList.add(l);
            l.clear();
        }
        System.out.println(dataList);


    }




}
