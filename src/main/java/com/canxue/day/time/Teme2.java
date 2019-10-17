package com.canxue.day.time;

import com.canxue.day.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * @Author Lishuntao
 * @Date 2019/10/17
 */
public class Teme2 {

    @Test
    public void bu() {

        LocalDate lt = LocalDate.now();


        LocalDate localDate = lt.plusDays(50);
        int diffDate = DateUtil.getDiffDate(lt, localDate);
        System.out.println(diffDate);

    }
}
