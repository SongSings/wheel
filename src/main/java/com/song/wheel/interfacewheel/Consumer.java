package com.song.wheel.interfacewheel;

import java.util.Objects;

/**
 * @author songjun
 * @date 2021-04-07
 * @desc Consumer消费者
 * @see java.util.function.Consumer
 * @see java.util.function.BiConsumer
 * @see java.util.function.IntConsumer
 */
@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}

class ConsumerTest{

    public static void main(String[] args) {
        Consumer<Integer> consumer = (x) -> System.out.println("x = " + x);
        consumer.accept(2);

        Consumer<Integer> consumer2 = (x) -> System.out.println("2222222");
        consumer.andThen(consumer2).accept(3);
        // “引用方法”(引用方法是用的冒号“::”来进行方法的调用)
        Consumer<Integer> consumer3 = System.out::println;
        consumer3.accept(6);

        // 匿名内部类实例 等同于上面的lambda实例
        // 1
        class ConsumerImpl<T> implements Consumer<T>{
            @Override
            public void accept(T t) {
                System.out.println("t = " + t);
            }
        }
        new ConsumerImpl<Integer>().accept(7777);
        // 2
        new Consumer<Long>() {
            @Override
            public void accept(Long aLong) {
                System.out.println("aLong = " + aLong);
            }
        }.accept(9L);
    }
}