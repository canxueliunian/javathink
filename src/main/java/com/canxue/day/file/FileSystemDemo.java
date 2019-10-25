package com.canxue.day.file;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.attribute.UserPrincipalLookupService;

/**
 * @Author Lishuntao
 * @Date 2019/10/25
 */
public class FileSystemDemo {

    static void show(String id, Object o) {
        System.out.println(id + ":" + o);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        FileSystem fsys = FileSystems.getDefault();
        for (FileStore s : fsys.getFileStores()) {
            show("file store", s);
        }

        Iterable<Path> rootDirectories = fsys.getRootDirectories();

        for (Path rd: rootDirectories) {
            show("root diretory",rd);
        }

        UserPrincipalLookupService userPrincipalLookupService = fsys.getUserPrincipalLookupService();
        System.out.println("user"+ userPrincipalLookupService);

        boolean open = fsys.isOpen();
        System.out.println("open "+ open);

        boolean readOnly = fsys.isReadOnly();
        System.out.println("readonly:" + readOnly);



    }
}
