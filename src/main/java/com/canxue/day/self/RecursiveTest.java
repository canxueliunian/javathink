package com.canxue.day.self;

/**
 * @Author Lishuntao
 * @Date 2019/10/9
 * lamdba 递归函数
 */
interface IntCall {
    int call(int arg);
}

public class RecursiveTest {
    static IntCall fact;

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        for (int i = 0; i <= 10; i++) {
            System.out.println(fact.call(i));
        }


    }


}
