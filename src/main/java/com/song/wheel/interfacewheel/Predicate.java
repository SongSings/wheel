package com.song.wheel.interfacewheel;

import java.util.Objects;

/**
 * @author songjun
 * date 2021-04-07
 * @desc Predicate断言
 * @see java.util.function.Predicate
 */
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    default Predicate<T> negate() {
        return (t) -> !test(t);
    }

    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }
}

class PredicateTest{
    public static void main(String[] args) {
        Predicate<Integer> predicate = (number)->number.equals(4);
        System.out.println(predicate.test(4));

        Predicate<Integer> predicate2 = (value)->value>3;

        System.out.println("predicate2.and(predicate).test(4) = " + predicate2.and(predicate).test(4));
        System.out.println("predicate.or(predicate).test(4) = " + predicate.or(predicate2).test(4));
        System.out.println("predicate.negate().test(3) = " + predicate.negate().test(3));

        Predicate<Object> equal = Predicate.isEqual(4);
        System.out.println("equal.test(3) = " + equal.test(3));

    }
}
