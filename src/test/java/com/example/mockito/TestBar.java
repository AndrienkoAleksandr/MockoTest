package com.example.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


/**
 * Created by logarifm on 04.09.14.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestBar {

    @Mock
    private Foo foo;

    @InjectMocks
    private Bar bar;

    @Test
    public void testBarMethods() {
        bar.bar("qwe");
        verify(foo).foo("qwe");
    }

    @Test
    public void testBarMethodWithAnyString() {
        bar.bar("any");
        verify(foo).foo(anyString());
    }

    @Test
    public void testBarMethodReturn() {
        when(foo.foo("any")).thenReturn("your");

        assertEquals(bar.bar("any"), "your");

    }

    @Test
    public void testBarMethodReturn2() {
        stub(foo.foo("anyway")).toReturn("your");

        assertEquals(bar.bar("anyway"), "your");
    }

    @Test
    public void testBarMethodReturn3() {
        doReturn("your").when(foo).foo("anyway");
        assertEquals(bar.bar("anyway"), "your");
    }

    @Test
    public void testBarMethodReturnWithAnyInputParametrs() {
        when(foo.foo(anyString())).thenReturn("abba");
        assertEquals(bar.bar("try1"), "abba");
        assertEquals(bar.bar("try2"), "abba");
    }

    @Test
    public void teatEasyMather() {
        bar.bar("12a");
        verify(foo).foo(matches("..."));
    }


    @Test
    public void teatDifficultMather() {
        bar.bar("12a");
        verify(foo).foo(matches("[a-z]*[1-9]*[a-z]*"));
    }


}
