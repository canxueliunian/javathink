package com.canxue.day.liu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

/**
 * @author canxue
 * @create2019-10-13-21:28
 */
public class Rands {

 static  void repeat(int n,Runnable action){
       range(0,n).forEach(i->action.run());
   }

    public static void main(String[] args) {


        System.out.println(range(10,20).sum());
        repeat(3,()->System.out.println("ddd"));

        Stream.Builder<String> builder = Stream.builder();
        List<String> list = new ArrayList<String>(){
            {
                add("1111");
                add("22222");
                add("44444");
                add("33333");
                add("666666");
            }
        };
        list.forEach(builder::add);
        builder.build().limit(7).map(w->w+"").forEach(System.out::println);
    }
}
