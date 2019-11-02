package com.cybertek.SortPractices;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgPract {
    @BeforeClass
    public static void AfterCLass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public static void setup(){
        System.out.println("before method");
    }


    @Test(priority = 3)
    public static void test1() {
        String word1 = "Java";
        String word2 = "Java";
        System.out.println("Test1");
        Assert.assertEquals(word1,word2);

    }

    @Test (priority = 2)
    public static void test2() {
        String word1 = "tava";
        String word2 = "tava";
        System.out.println("Test2");
        Assert.assertEquals(word1,word2);

    }
    @Test(priority = 1)
    public static void test3() {

        Assert.assertTrue(5<15);
        System.out.println("Test3"
        );

    }
    @AfterMethod
    public static void teardown(){
        System.out.println("After method");

    }
    @AfterClass
    public static void  AfterClass(){
        System.out.println("After class");
    }

}
