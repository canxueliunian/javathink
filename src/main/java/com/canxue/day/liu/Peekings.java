package com.canxue.day.liu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author canxue
 * @create2019-10-15-23:04
 */
public class Peekings {
    public static void main(String[] args)  {
        try {
            String fname = "C:\\Users\\14197\\IdeaProjects\\demo\\src\\main\\resources\\Cheese.dat";
            Path path = Paths.get(fname);
            String s = path.toString();
            System.out.println(s);
//            List<String> lines = Files.readAllLines(Paths.get(fname));
//            lines.stream().skip(1).limit(4).map(w -> w + " ")
//                    .peek(System.out::println)
//                    .map(w -> w.toUpperCase())
//                    .peek(System.out::println)
//                    .map(String::toLowerCase)
//                    .forEach(System.out::println);
//            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
