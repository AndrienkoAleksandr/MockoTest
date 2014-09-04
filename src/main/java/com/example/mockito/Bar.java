package com.example.mockito;

/**
 * Created by logarifm on 04.09.14.
 */
public class Bar {
    private Foo foo;
    public Bar(Foo foo) {
        this.foo = foo;
    }

    public String bar(String parameter) {
        return foo.foo(parameter);
    }
}
