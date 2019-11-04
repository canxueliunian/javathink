package com.canxue.day.file;

import lombok.Data;

/**
 * @Author Lishuntao
 * @Date 2019/10/31
 */
@Data
public class People {
    private String  name ;

    @Override
    public String toString() {
        return "People{" + super.toString();
    }


    public static void main(String[] args) {
        People people = new People();
        System.out.println(people);
    }
}
