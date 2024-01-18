package com.myblog.myblog11;


import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestClass {
    public static void main(String[] args) {

 Consumer<String> data=  name-> System.out.println(name);
 data.accept("Manish");


    }
}
