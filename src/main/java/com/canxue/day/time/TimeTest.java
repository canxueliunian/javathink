package com.canxue.day.time;

import com.canxue.day.LocalDateUtil;
import org.junit.jupiter.api.Test;

import java.time.*;


/**
 * @Author Lishuntao
 * @Date 2019/10/16
 * https://www.jianshu.com/p/81f467b4457c
 * https://www.jianshu.com/p/93c7bcbc9397
 * <p>
 * 时间类的使用， 以及对应的设置， 以及与dateclaner的转换使用
 */
public class TimeTest {

    @Test
    public void testInstant() {
        // 获取当前时间
        Instant now = Instant.now();
        System.out.println(now);
        // 根据毫秒获取当前时间
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println("毫秒时间" + instant);
        // 获取时区时间
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("上海时间为" + zonedDateTime);
    }

    @Test
    public void testLocalTime() {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime of = LocalDateTime.of(LocalDate.of(2019, 11, 23), now.toLocalTime());
        Month month = of.getMonth();
    }

    @Test
    public void testZoneDate() {
        // 获取当前时间
//        ZoneOffset 处理与标准时的时间差
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.toInstant(ZoneOffset.of("+01:00"));
        System.out.println(instant);
    }

    @Test
    public void testDateFormat() {
        LocalDate now = LocalDate.now();
        System.out.println(LocalDateUtil.getMonthDays(now));


    }

}