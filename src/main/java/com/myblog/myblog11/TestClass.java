package com.myblog.myblog11;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.cglib.core.internal.Function;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
//
List<Integer> data1 = Arrays.asList(10,15,18,65,42);
List<Integer> result1= data1.stream().filter(x->x.toString().startsWith("1")).collect(Collectors.toList());
        System.out.println(result1);


//// Filter out the String word "Java" in the given word lists
  List<String> str = Arrays.asList("Java is a language","C++ is oop's language", "python is very easy", "JavaScript is backdated");
 List<String> res =  str.stream().filter(s->!s.contains("Java")).collect(Collectors.toList());

        System.out.println(res);

//// word starts with letter 'a':
 List<String> data = Arrays.asList("deb", "arka", "roy");
 List<String> result= data.stream().filter(s->s.startsWith("r")).collect(Collectors.toList());

        System.out.println(result);

//Filter out names that have exactly four letters:

  List<String> names=  Arrays.asList("john","ram", "swagata", "elephant");
  List<String> name = names.stream().filter(n->n.length()==3).collect(Collectors.toList());

        System.out.println(name);


// Filter out the nos greater than 50:

       List<Integer> no =  Arrays.asList(78,56,10,19,45);
     List<Integer> r = no.stream().filter(n->n<=50).collect(Collectors.toList());
        System.out.println(r);
    }



}
