package com.myblog.myblog11;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {

        // predicate functional interface

        Predicate<String> str = x->x.equals("aryan");
        boolean b1 = str.test("aryan");
        System.out.println(b1);

        Predicate<Integer> val = y->y%5==0;
       boolean b=  val.test(25);
        System.out.println(b);

        // Stream API
        List<Integer> num = Arrays.asList(10,12,1,5,16,19,20);
        List<Integer>result= num.stream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println(result);


        List<String> data = Arrays.asList("mike", "deb", "ankit", "maven");
        List<String> res=  data.stream().filter(s->s.equals("mike")).collect(Collectors.toList());
        System.out.println(res);
    }
}
