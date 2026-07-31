package com.bank;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Assert Equals
        assertEquals(5, 2 + 3);

        // Assert True
        assertTrue(5 > 3);

        // Assert False
        assertFalse(5 < 3);

        // Assert Null
        assertNull(null);

        // Assert Not Null
        assertNotNull(new Object());

        // Assert Same
        String s1 = "Hello";
        String s2 = s1;
        assertSame(s1, s2);

        // Assert Not Same
        String s3 = new String("Hello");
        assertNotSame(s1, s3);

        // Assert Array Equals
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }
}