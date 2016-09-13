package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tester {

    @Test
    public void stringTest() {
        JustAnotherClass object = new JustAnotherClass();
        assertEquals("MAKE ME LARGE", object.toUpper("make me large"));
    }
}
