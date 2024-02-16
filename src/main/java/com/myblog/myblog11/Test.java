package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//package com.myblog.myblog11;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
public class Test {

    public static void main(String[] args) {

        List<String> data = Arrays.asList("ram", "sam", "jadu", "ankit");

        Consumer<String > val= n-> System.out.println(n);
        data.forEach(val);
    }
}
