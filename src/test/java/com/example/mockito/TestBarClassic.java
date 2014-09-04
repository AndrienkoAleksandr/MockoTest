package com.example.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by logarifm on 04.09.14.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestBarClassic {

    private Foo foo;

    private Bar bar;

    @Before
    public void init() {
        foo = Mockito.mock(Foo.class);
        bar = new Bar(foo);
    }

    @Test
    public void testBar() {
        bar.bar("qwe");
        verify(foo).foo("qwe");
    }
}
