package com.canxue.day.junittest;

import com.google.common.base.VerifyException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.base.Verify.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void insert() {
        try {
            verify(1 + 2 == 4, "bad match ");

            String s = "";
            s = verifyNotNull(s);
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
            assert true;
        }

    }


}
