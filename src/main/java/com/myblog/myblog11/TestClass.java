package com.myblog.myblog11;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.cglib.core.internal.Function;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {

        // Function functional interface -> it takes input and provides output
        // map() is a method which takes function functional interface, we cant

       Function<String,Integer> data =  str->str.length();
       Integer a = data.apply("aryan");
        System.out.println(a);

       Function<Integer, Integer> f = i->i+10;
      Integer  x =  f.apply(50);
        System.out.println(x);

        List<String> names= Arrays.asList("arka","deb","mike","ram");
       List<String> name=  names.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(name);

       List<Integer> val =  Arrays.asList(10,20,30);
      List<Integer> sum =  val.stream().map(i->i+10).collect(Collectors.toList());
        System.out.println(sum);


    }

}
