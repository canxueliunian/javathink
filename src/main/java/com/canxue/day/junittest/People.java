package com.canxue.day.junittest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author Lishuntao
 * @Date 2019/10/23
 */
@Data
@Slf4j
public class People {

    private String name;
    private Integer age;


    public static void main(String[] args) {
       String s ="'这是一个测试'/10/20";
        String[] split = s.split("/");
        String d = split[0];

        if (d.startsWith("'")){
            System.out.println("hany");
        }
        if (d.endsWith("'")){
            System.out.println("jhhh");
        }
    }
    @Test
    public void test02(){


        StringBuffer s = new StringBuffer("1,2,3,4,5,");
        s.delete(s.length()-1,s.length());
        System.out.println(s);



    }
}
