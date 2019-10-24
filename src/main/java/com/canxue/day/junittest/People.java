package com.canxue.day.junittest;

import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

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
}
