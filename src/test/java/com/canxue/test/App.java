package com.canxue.test;

/**
 * @Author Lishuntao
 * @Date 2019/12/19
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < 1000; i++) {
                list.add(i + ",");
            }


            System.out.println(list2Str(list, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String list2Str(List<String> list, final int nThreads)
            throws Exception {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        List<List<String>> lists = new ArrayList<>();
        int size1 = list.size();
        int start = 0;
        int end = 300;
        while (size1 > 300) {
            List<String> strings = list.subList(start, end);
            lists.add(strings);
            size1 = size1 - 300;
            start = start + 300;
            end = end + 300;
        }
        lists.add(list);
        int num = 0;

        for (List<String> l : lists) {
            num = num + 1;
            System.out.println();
            int finalNum = num;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread " + finalNum + "start");
                    for (String to : l) {
                        System.out.println(to);
                    }
                    try {
                        wait(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("thread " + finalNum + "end");
                }
            });
            System.out.println("end");

        }


//        StringBuffer ret = new StringBuffer();
//
//        int size = list.size();
//
//        List<Future<String>> futures = new ArrayList<Future<String>>(nThreads);
//        for (int i = 0; i < nThreads; i++) {
//            final List<String> subList = list.subList(size / nThreads * i, size/ nThreads * (i + 1));
//            Callable<String> task = new Callable<String>() {
//                public String call() throws Exception {
//                    StringBuffer sb = new StringBuffer();
//                    for (String str : subList) {
//                        sb.append(str);
//                    }
//                    return sb.toString();
//                }
//            };
//            futures.add(executorService.submit(task));
//        }
//
//        for (Future<String> future : futures) {
//            ret.append(future.get());
//        }
//        executorService.shutdown();
//
//        return ret.toString();
        return "";
    }

}