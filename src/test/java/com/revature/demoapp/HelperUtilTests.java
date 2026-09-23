package com.revature.demoapp;

import com.revature.demoapp.utils.HelperUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
//deterministic
public class HelperUtilTests {//AAA-> Arrange , Act, Assert
    HelperUtil util;

    @BeforeAll
    static void init(){
       //
    }

    @BeforeEach
    void setup(){
        this.util = new HelperUtil();
    }

    @Test
    void testDoOperation(){
        int res = util.doOperation("add", 1,12);
        int res2 = util.doOperation("subtract", 20,7);

        Assertions.assertEquals(13, res);
        Assertions.assertEquals(13, res2);
    }

    @Test
    void testMultiply(){
        int res = util.multiply(Arrays.asList(1,2,3,4,5));
        Assertions.assertEquals(120,res);
    }

    @Test
    void testDivide(){
        int res1 = util.divide(1,4);
//        int res2 = util.divide(3,0);
        Assertions.assertEquals(0, res1);
        Assertions.assertThrows(ArithmeticException.class, ()-> util.divide(3,0));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "20, 30, 50",
            "100, 200, 300",
            "120, 230, 350",
            "0, 0, 0",
            "-1, 1, 0"
    })
    void testDoOpertaion(int a, int b, int expected_val){
        Assertions.assertEquals(expected_val, util.doOperation("add", a, b));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,45,34,34,90,28})
    void testNumbers(int n){

    }

    @AfterEach
    void clean(){
        System.out.println("Clean up");
    }

    @AfterAll
    static void close(){
        System.out.println("closing tests");
    }


}
