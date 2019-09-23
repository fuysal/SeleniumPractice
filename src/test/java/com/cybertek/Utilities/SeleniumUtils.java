package com.cybertek.Utilities;

public class SeleniumUtils {
    /**
     *         VERIFIES IF TO STRINGS ARE EQUALS
     * */
    public static void verifyEquals(String expectedResult, String actualResult){
        if (expectedResult.equals(actualResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected result: "+ expectedResult);
            System.out.println("Actual result: "+ actualResult);
        }
    }
}
