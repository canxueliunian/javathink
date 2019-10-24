package com.canxue.day.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Spliterator;

/**
 * @Author Lishuntao
 * @Date 2019/10/24
 */
public class FileTest {

    static void show(String id, Object p) {
        System.out.println(id + ":" + p);
    }

    static void info(Path p) {
        show("toSting", p);
        show("exists", Files.exists(p));
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("******************");
    }

    public static void main(String[] args) {
        //获取所有的属性
        Properties properties = System.getProperties();
        //遍历所有的属性
        for (String key : properties.stringPropertyNames()) {
            //输出对应的键和值
            System.out.println(key + "=" + properties.getProperty(key));
        }

        System.out.println(System.getProperty("os.name"));
        info(Paths.get("C:", "path", "to", "nowhere", "NoFile.txt"));

        Path p = Paths.get("D:\\myproject\\javathink\\target\\classes\\com\\canxue\\day\\file\\FileTest.class");
        info(p);
        Path ap = p.toAbsolutePath();
        info(ap);
        info(ap.getParent());
        try {
            info(p.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
        URI u = p.toUri();
        System.out.println("URI: " + u);
        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));
        File f = ap.toFile(); // Don't be fooled
        f.exists();
    }


    @Test
    public void test01() throws URISyntaxException {


        Path path = Paths.get("pro/b.txt");
        System.out.println("路径:" + path.toString());
        int nameCount = path.getNameCount();
        System.out.println("path 的绝对路径" + path.toAbsolutePath());
        File file = path.toFile();
        URI uri = path.toUri();
        path = path.toAbsolutePath();


        System.out.println("path 的父路径" + path.getParent());
        System.out.println("path 的目录名" + path.getFileName());
        System.out.println("根路径" + path.getRoot());
        Spliterator<Path> spliterator = path.spliterator();
        String s = spliterator.toString();
        System.out.println(s);
        boolean absolute = path.isAbsolute();
        System.out.println(absolute);
    }

    @Test
    public void partsOfPaths() {
        System.out.println(System.getProperty("os.name"));
        Path path = Paths.get("FileTest.java").toAbsolutePath();
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(path.getName(i));
        }

        System.out.println("end with '.java'" + path.endsWith(".java"));
        for (Path pp : path) {
            System.out.print(pp + ": ");
            System.out.print(path.startsWith(pp) + " : ");
            System.out.println(path.endsWith(pp));

        }

        System.out.println("starts with" + path.getRoot() + " " + path
                .startsWith(path.getRoot()));


    }


}
