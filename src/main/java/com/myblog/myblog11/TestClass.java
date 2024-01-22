package com.myblog.myblog11;


import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestClass {
    public static void main(String[] args) {

        TestClass t = new TestClass();
        System.out.println(100);
        int a = t.test();

        System.out.println(a);


    }
    public int test(){

        int res = EmployeeTest.test1();

        return res;
    }
}
