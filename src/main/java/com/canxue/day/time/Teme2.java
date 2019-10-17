package com.canxue.day.time;

import com.canxue.day.LocalDateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @Author Lishuntao
 * @Date 2019/10/17
 */
public class Teme2 {

    @Test
    public void bu() {

        LocalDate lt = LocalDate.now();


        LocalDate localDate = lt.plusDays(50);
        int diffDate = LocalDateUtil.getDiffDay(lt, localDate);
        System.out.println(diffDate);

    }
}
