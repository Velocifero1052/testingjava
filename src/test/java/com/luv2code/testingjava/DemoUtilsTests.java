package com.luv2code.testingjava;

import com.luv2code.testingjava.util.DemoUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DemoUtilsTests {

    DemoUtil demoUtils;

    @BeforeAll
    static void beforeAllSetup(){
        System.out.println("before all setup");
    }

    @BeforeEach
    void setupBeforeEach(){
        demoUtils = new DemoUtil();
    }

    @Test
    /*@DisplayName("test equals and not equals")*/
    void testEqualsAndNotEquals() {
        System.out.println("Running test: testEqualsAndNotEquals");
        //set up

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
    /*@DisplayName("test null and not null")*/
    void testNullAndNotNull(){
        //setup
        String str1 = null;
        String str2 = "It's a not null string";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");

    }

    @Test
    void sameOrNotTheSame(){
        String expected = "luv2code";
        String notExpected = "dontLuv2Code";
        assertSame(expected, demoUtils.getAcademyName());
        assertNotSame(notExpected, demoUtils.getAcademyName());
    }

    @Test
    void trueOrNotTrue(){
        var a = 2;
        var b = 1;
        assertTrue(demoUtils.isGreater(a, b));
        assertFalse(demoUtils.isGreater(b, 1));
    }


    @AfterAll()
    static void afterAllCleanup(){
        System.out.println("after all setup");
    }
}
