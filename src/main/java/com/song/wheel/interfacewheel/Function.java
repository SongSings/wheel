package com.song.wheel.interfacewheel;

import java.util.Objects;

/**
 * @author songjun
 * date 2021-04-07
 * @desc 函数型接口
 */
@FunctionalInterface
public interface Function<T,R> {

    R apply(T t);

    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
class FunctionTest{
    public static void main(String[] args) {
        Function<Integer,Integer> function = (x)->{return x*10;};
        System.out.println("function.apply(6) = " + function.apply(6));
        Function<Integer,Integer> function2 = (x)-> x+5;
        // 先执行 function2 拿到结果执行function
        System.out.println("function.compose(function2).apply(3) = " + function.compose(function2).apply(3));

        System.out.println("function.andThen(function2).apply(3) = " + function.andThen(function2).apply(3));

        Function<String, String> identity = Function.identity();
        System.out.println("identity.apply(\"4\") = " + identity.apply("4"));
    }
}