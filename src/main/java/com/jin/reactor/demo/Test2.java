package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * @author wu.jinqing
 * @date 2020年09月14日
 */
public class Test2 {
    public static void main(String[] args) {
        Flux<Integer> ints = Flux.range(1, 4).map(i ->
        {
            if(i <= 4)
            {
                return i;
            }

            throw new RuntimeException("Got to 4");
        });


        ints.subscribe(i -> {
            System.out.println(i);
        }, error -> {
            System.err.println("Error:" + error);
        });


        System.out.println("=================");


        ints.subscribe(System.out::println, System.out::println, () -> System.out.println("Done."));
    }
}
