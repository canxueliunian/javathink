package com.canxue.day.self;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/**
 * @Author Lishuntao
 * @Date 2019/10/11
 */
class Foo {
}

class Bar {
    Foo f;

    Bar(Foo f) {
        this.f = f;
    }
}

class IBaz {
    int i;

    IBaz(int i) {
        this.i = i;
    }
}

class LBaz {
    long l;

    LBaz(long l) {
        this.l = l;
    }
}

class DBaz {
    double d;

    DBaz(double d) {
        this.d = d;
    }
}

class In1 {
}

class In2 {
}


public class FunctionVariants {
    static Function<Foo, Bar> f1 = f -> new Bar(f);
    static IntFunction<IBaz> f2 = i -> new IBaz(i);
    static ToIntFunction<IBaz> f3 = i -> i.i;
    static IntToLongFunction f10 = i -> i;

    static void accept(In1 i1, In2 i2) {
        System.out.println("accept()");
    }

    static void someOtherName(In1 i1, In2 i2) {
        System.out.println("someOtherName()");
    }

    public static void main(String[] args) {

        Bar apply = f1.apply(new Foo());
        IBaz apply1 = f2.apply(12);
        int i = f3.applyAsInt(new IBaz(1));
        BiConsumer<In1, In2> bic;
        bic = FunctionVariants::accept;
        Predicate<String> condition1 = str -> str.startsWith("j");
        Predicate<String> condition2 = str -> str.endsWith("h");
        Predicate<String> andCondition = condition1.and(condition2);

    }
}
