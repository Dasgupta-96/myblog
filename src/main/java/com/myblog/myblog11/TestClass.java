package com.myblog.myblog11;


import ch.qos.logback.core.net.server.ConcurrentServerRunner;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.cglib.core.internal.Function;
import org.yaml.snakeyaml.nodes.CollectionNode;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        // Consumer functional interface takes input and produces no output
      Consumer<String> result=  name-> System.out.println(name);
        result.accept("debu");

// Example 2:

      List<String> names=  Arrays.asList("ram", "sam", "rita");
      Consumer<String> val = name-> System.out.println(name);
      names.forEach(val);
    }
}
