package com.canxue.day.junittest;

import com.google.common.base.VerifyException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Verify.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static com.google.common.base.Preconditions.*;

/**
 * @Author Lishuntao
 * @Date 2019/10/22
 */
public class CountedListTest {

    private CountedList list;

    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">> Staring CountedListTest");
    }

    @AfterAll
    static void afterAllMsg() {
        System.out.println(">> Finished CountedListTest");
    }

    @BeforeEach
    public void initialize() {
        list = new CountedList();
        System.out.println("set up for " + list.getId());
        for (int i = 0; i < 3; i++) {
            list.add(Integer.toString(i));
        }


    }

    @AfterEach
    public void cleanup() {
        System.out.println("Cleaning up " + list.getId());
    }

    public static Logger logger = LoggerFactory.getLogger(CountedListTest.class);

    @Test
    public void insert() {
//        assertEquals("s" ,"sssss");
        assertFalse(true,"this is false");
        assertEquals("ss", "put() null item","cuowumassegw");



    }


}
