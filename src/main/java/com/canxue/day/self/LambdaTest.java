package com.canxue.day.self;

import lombok.Data;

import java.util.function.Consumer;

/**
 * @Author Lishuntao
 * @Date 2019/10/9
 */
interface Body {
    String detailed(String head);
}
interface Description {
    String brief();
}
interface Multi {
    String twoArg(String head, Double d);
}
@Data
public class LambdaTest {
    private String h;


    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        String msg = "hi";
        Body body = h -> h + "no Parents";
        Body body2 = (h) -> h + "no Parents";
        Description description = () ->  "no Parents";
        Multi multi = (h,g) -> h + "no Parents"+g;
        Consumer<String> con = (x) -> System.out.println(x);
        System.out.println(body.detailed("oh"));
        System.out.println(body2.detailed("oh"));
        System.out.println(description);
        System.out.println(multi.twoArg("oh",1.2d));
        System.out.println(body.detailed("oh"));
    }
}
