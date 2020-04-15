package com.canxue.day.zhujie;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author Lishuntao
 * @Date 2019/12/25
 * @version 1.0
 */
public class UseCaseTracker {

    /**
     *
     * @param useCases
     * @param cl
     * @throws Exception
     * @since 1.6
     */
    public static void takeUseCases(List<Integer> useCases, Class<?> cl) throws Exception{
        for (Method m : cl.getDeclaredMethods()) {
            UseCase annotation = m.getAnnotation(UseCase.class);
            if (annotation != null) {
                System.out.println("found use case " + annotation.id() + "  description  "
                        + annotation.description());
                useCases.remove(Integer.valueOf(annotation.id()));
            }
        }

//        useCases.forEach(i -> System.out.println("Missing  user case:" + i));


    }

    /**
     * @see UseCaseTracker#takeUseCases(List, Class)
     * @param args
     * @throws Exception
     * {}@link UseCaseTracker#takeUseCases(List, Class) ceshi}
     * 这是一个号的处理方法 {@code String}
     */
    public static void main(String[] args) throws Exception {
        List<Integer> useCases = IntStream.range(47,51).boxed().collect(Collectors.toList());
        takeUseCases(useCases,PasswordUtils.class);

    }

}
