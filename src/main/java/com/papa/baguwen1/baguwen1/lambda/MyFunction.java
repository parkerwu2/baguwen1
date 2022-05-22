package com.papa.baguwen1.baguwen1.lambda;

@FunctionalInterface
public interface MyFunction<T> {
    T getValue(T t);
}
