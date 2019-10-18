package com.canxue.day.time;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.canxue.day.LocalDateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author Lishuntao
 * @Date 2019/10/17
 * json 与localdatetime的转换处理
 */
public class Teme2 {

    @Test
    public void bu() {

       Base base = new Base();
       base.setId(13L);
       base.setLocalDateTime(LocalDateTime.now());


        String s1 = JSON.toJSONStringWithDateFormat(base, LocalDateUtil.DEFAULT_PATTERN);
        System.out.println(s1);
        String s = JSON.toJSONString(base);
        System.out.println(s);


    }
}
