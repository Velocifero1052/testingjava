package com.luv2code.testingjava;

import com.luv2code.testingjava.util.DemoUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.Random.class)
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
        String unexpectedValue = "luv2code2";
        assertSame(demoUtils.getAcademyName(), demoUtils.getAcademyNameDuplicate());
        assertNotSame(unexpectedValue, demoUtils.getAcademyName());
    }

    @Test
    void trueOrNotTrue(){
        var a = 2;
        var b = 1;
        assertTrue(demoUtils.isGreater(a, b));
        assertFalse(demoUtils.isGreater(b, 1));
    }

    @Test
    void testArrayEquals(){
        var expected = new String[]{"A", "B", "C"};
        assertArrayEquals(expected, demoUtils.getFirstThreeLettersOfAlphabet());
    }

    @Test
    void testIterableEquals(){
        var expected = List.of("luv", "2", "code");
        assertIterableEquals(expected, demoUtils.returnIterable());
    }

    @Test
    void assertThrowsAndNotThrows(){
        var positiveNumber = 1;
        var negativeNumber = -1;
        assertThrows(Exception.class, () -> {demoUtils.throwOnNegative(negativeNumber);});
        assertDoesNotThrow(() -> {demoUtils.throwOnNegative(positiveNumber);});
    }

    @Test
    void assertThrowsInterruptedException() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {demoUtils.checkTimeout();});
    }

    @Test
    @Disabled("enable after issue #345 will be fixed")
    void someDisabledTest(){

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void someServerTest(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void someCompatabiltyTest(){
        
    }

    @Test
    void testMultiply(){
        var a = 3;
        var b = 4;
        var res = a * b;
        assertEquals(res, demoUtils.multiply(a, b));
    }
    @AfterAll()
    static void afterAllCleanup(){
        System.out.println("after all setup");
    }
}
