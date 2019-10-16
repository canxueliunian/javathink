package com.canxue.day.liu;

import lombok.Data;

/**
 * @Author Lishuntao
 * @Date 2019/10/15
 */
@Data
public class Bubble {
    private int name;
    public Bubble(int i) {
        this.name =i;
    }

    @Override
    public String toString() {
        return "Bubble{" +
                "name=" + name +
                '}';
    }
}
