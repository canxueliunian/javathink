package com.canxue.day.flow;

import java.util.*;

/**
 * @author canxue
 * @create2019-10-08-22:51 list 遍历器
 */
public class ListIteration {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(11);
                add(12);
                add(13);
                add(14);
                add(15);
                add(16);
                add(17);
            }
        };
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + "," +
                    iterator.nextIndex()
                    + "," + iterator.previousIndex() + ";");
        }
        System.out.println("后置循环");
        while (iterator.hasPrevious()){
            System.out.println(
                    iterator.previous()
            );
            System.out.println("前置循环");

        }
        iterator = list.listIterator(3);
        while (iterator.hasNext()){
            iterator.next();
            iterator.set(1);
        }
        System.out.println(list);


      PriorityQueue priorityQueue = new PriorityQueue();

        Comparator<Integer> comparator= new Comparator<Integer>() {
                @Override
            public int compare(Integer o1, Integer o2) {
//                    if (o1.equals(o2)){
//                        return 0;
//                    }else if (){
//
//                    }
                return 0;
            }
        };
    }



}
