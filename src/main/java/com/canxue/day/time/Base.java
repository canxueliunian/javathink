package com.canxue.day.time;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Lishuntao
 * @Date 2019/10/18
 */
@Data
public class Base {

    private Long id;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

}
