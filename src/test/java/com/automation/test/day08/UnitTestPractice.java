package com.automation.test.day08;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {

        String expected="cba";
        String toReverse="abc";
        String actual=reverseString(toReverse);
        verifyEquals(expected, actual);
    }
   //annotation
    @Test(description = "Verify if method can reverse a string")
    public void test(){
        String expected="elppa";
        String actual=reverseString("apple");
        Assert.assertEquals(actual, expected);

    }
    @Test
    public void test2(){
       String expected= "rac";
       String actual=reverseString("car");
       Assert.assertEquals(expected, actual);



    }
    public static boolean verifyEquals(String expected, String actual){

        if(expected.equals(actual)){
            System.out.println("Test Passed");
            return true;
        }else{
            System.out.println("Expected "+expected);
            System.out.println("Actual "+actual);
            System.out.println("Test Failed");
        }
        return false;

    }

    public static String reverseString(String str){

        String reversed="";

        for (int i = str.length()-1; i>=0 ; i--) {

            reversed += str.charAt(i);
        }
        return reversed;
    }



}
