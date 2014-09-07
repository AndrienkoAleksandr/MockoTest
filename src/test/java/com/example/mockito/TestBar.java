package com.example.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

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
        bar.bar("1a4");
        verify(foo).foo(matches("..."));
    }

    @Test
    public void test5() {
        bar.bar("qwe");
        verify(foo).foo(endsWith("we"));
        verify(foo).foo(contains("w"));
        verify(foo).foo(startsWith("qw"));
        System.out.println(bar.bar("qwe"));
    }

//    @Test (expected = IllegalArgumentException.class)
//    public void excluding() {
//        FooVoid foo = mock(FooVoid.class);
//        BarVoid bar = new BarVoid(foo);
//        doNothing().when(foo).foo("qwe");
//        doThrow(new IllegalArgumentException()).when(foo).foo(anyString());
//
//        bar.bar("qwe");
//        verify(foo).foo("qwe");
//        bar.bar("ss");
//    }

    @Test
    public void teatDifficultMather() {
        bar.bar("abcd12a");
        verify(foo).foo(matches("[a-z]{1,4}[1-9]*[a-z]*"));
    }

    @Test
    public void thenAnsver() {
        Foo foo = mock(Foo.class);
        Bar bar = new Bar(foo);
// gi ven
        when(foo.foo(anyString())).thenAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                if (args[0].equals("qwe")) {
                    return "asd";
                }
                if (args[0].equals("qwr")) {
                    return "qwe";
                }
                if (args[0].equals("abc")) {
                    return "abc";
                }
                return null;
            }
        });
        assertEquals("asd", bar.bar("qwe"));
        assertEquals("qwe", bar.bar("qwr"));
        assertEquals("abc", bar.bar("abc"));
        assertEquals(null, bar.bar("fdfdff"));
    }

}
