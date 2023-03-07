package com.luv2code.testingjava;

import com.luv2code.testingjava.util.DemoUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestingjavaApplicationTests {

    @Test
    void testEqualsAndNotEquals() {
        //set up
        var demoUtils = new DemoUtil();

        int expected = 6;
        int unexpected = 8;
        int a = 2;
        int b = 4;

        //execute
        int actual = demoUtils.add(a, b);

        //assert
        assertEquals(expected, actual, String.format("%d+%d must be %d", a, b, expected));
        assertNotEquals(unexpected, actual, String.format("%d+%d mustn't be %d", a, b, unexpected));
    }

    @Test
    void testNullAndNotNull(){
        //setup
        var utils = new DemoUtil();

        String str1 = null;
        String str2 = "It's a not null string";

        assertNull(utils.checkNull(str1), "Object should be null");
        assertNotNull(utils.checkNull(str2), "Object should not be null");

    }
}
