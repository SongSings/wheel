package com.song.wheel.interfacewheel;

/**
 * @author songjun
 * @date 2021-04-07
 * @desc Supplier生产者
 * @see java.util.function.Supplier<T>
 */
@FunctionalInterface
public interface Supplier<T> {

    T get();
}

class SupplierTest{
    public static void main(String[] args) {
        Supplier<String> supplier = ()-> "ssr";
        System.out.println(supplier.get());
    }
}
