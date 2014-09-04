package com.example.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


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
}
