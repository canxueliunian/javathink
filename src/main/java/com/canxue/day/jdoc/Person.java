package com.canxue.day.jdoc;

import cn.hutool.core.util.ZipUtil;

import java.io.File;

/**
 * 这是一个 java doc的测试class
 * @Author Lishuntao
 * @Date 2019/12/26
 */
public class Person {

    /**
     * 姓名
     */
    public String name;
    /**
     * @see Person#getAddress()
     * 学校 {@value}
     */
    public static String address ="test";

    /**
     * 地址编码 {@link String  地址编码}
     */
    public int addressCode;

    public String getName() {
        return name;
    }

    /**
     * 这是一个{@code string} 类型的参数
     * @param name   这是一个name注解
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return 地址
     */
    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Person.address = address;
    }

    public int getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(int addressCode) {
        byte[] gzip = ZipUtil.gzip(new File(""));
        this.addressCode = addressCode;
    }
}
