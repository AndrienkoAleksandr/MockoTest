package com.example.mockito;

/**
 * Created by logarifm on 04.09.14.
 */
public class BarVoid {
    private FooVoid fooVoid;
    public BarVoid(FooVoid fooVoidImpl) {
        this.fooVoid = fooVoid;
    }

    public void bar(String parameter) {
        fooVoid.foo(parameter);
    }
}
