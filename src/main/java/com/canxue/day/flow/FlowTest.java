package com.canxue.day.flow;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author canxue
 * @create2019-10-08-22:38
 */

interface Staregy {
    String approach(String msg);
}

interface IntCall {
    Integer call(int msg);
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}

public class FlowTest {

    static IntCall call;
    static IntCall fact;

    public static void main(String[] args) {

        List<Staregy> staregies = new ArrayList<Staregy>() {
            {
                add(new Staregy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                });
                add(msg -> msg.substring(0, 4));
                add(Unrelated::twice);
            }
        };


        // lamdba 递归循环

        call = n -> n == 0 ? 1 : n * call.call(n - 1);
        for (int i = 0; i <= 10; i++) {
            System.out.println(call.call(i));
        }

        new Thread(
                () -> System.out.println("12")).start();


        new Thread(Go::go).start();
    }


}
