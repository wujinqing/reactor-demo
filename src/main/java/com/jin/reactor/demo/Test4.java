package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * @author wu.jinqing
 * @date 2020年09月14日
 */
public class Test4 {
    public static void main(String[] args) {
        SampleSubscriber<Integer> ss = new SampleSubscriber<>();

        Flux<Integer> ints = Flux.range(1, 4);

        ints.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> {System.out.println("Done");},
                s -> s.request(10));

        System.out.println("==========");

        ints.subscribe(ss);
    }
}
