package com.canxue.day.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;

/**
 * @Author Lishuntao
 * @Date 2019/10/22
 */
public class AutoClose {


    public static void main(String[] args) {
        try (
                InputStream in = new FileInputStream(new File(""));
                PrintWriter outfile = new PrintWriter(
                        "Results.txt"); // [1]
        ) {
            int read = in.read();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
