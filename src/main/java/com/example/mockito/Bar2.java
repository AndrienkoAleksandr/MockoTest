package com.example.mockito;

/**
 * Created by logarifm on 04.09.14.
 */
public class Bar2 {
    private Foo foo1;
    private Foo foo2;

    public Bar2(Foo foo1, Foo foo2) {

    }

    public String bar(String parameters, String param) {
        foo1.foo(parameters);
        foo2.foo(parameters);
        return foo1.foo(param);
    }
}
