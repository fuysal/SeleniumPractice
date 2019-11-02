package com.cybertek.day8_testng_intro;


import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaTestNGDemo {
    @Test
    public static void test1(){
        String a = "A";
        String b = "B";
        Assert.assertEquals(a, b);
    }

    @Test
    public static void test2(){
        String str1 = "papa";
        String str2 = "mama";
        Assert.assertEquals(str1,str2);
    }
    @Test
    public static void test3(){
        String x = "JAVA";
        String y = "AVA";
        Assert.assertTrue(x.contains(y));
    }
    @Test
    public void test4(){
        Assert.assertFalse(false);
    }

}
