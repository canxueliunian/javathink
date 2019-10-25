package com.canxue.day.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * @Author Lishuntao
 * @Date 2019/10/25
 */
public class PathWatcher {
    static Path test = Paths.get("test");

    static void delTxtFiles(){
        try{
            Files.walk(test).filter(f-> f.toString().endsWith(".txt")).forEach(
                    f->{
                        System.out.println("deleting"+f);
                        try {
                            Files.delete(f);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception{

        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        WatchService watcher = FileSystems.getDefault().newWatchService();
        test.register(watcher, ENTRY_DELETE);
        Executors.newSingleThreadScheduledExecutor()
                .schedule(PathWatcher::delTxtFiles,
                        250, TimeUnit.MILLISECONDS);
        WatchKey key = watcher.take();
        for(WatchEvent evt : key.pollEvents()) {
            System.out.println("evt.context(): " + evt.context() +
                    "\nevt.count(): " + evt.count() +
                    "\nevt.kind(): " + evt.kind());
            System.exit(0);
        }


    }

}
