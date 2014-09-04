package com.example.mockito;

/**
 * Created by logarifm on 04.09.14.
 */
public class BarVoid {
    private FooVoidImpl fooVoidImpl;
    public BarVoid(FooVoidImpl fooVoidImpl) {
        this.fooVoidImpl = fooVoidImpl;
    }

    public void bar(String parameter) {
        fooVoidImpl.foo(parameter);
    }
}
