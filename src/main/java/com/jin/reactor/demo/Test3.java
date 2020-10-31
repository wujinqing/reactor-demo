package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * @author wu.jinqing
 * @date 2020年09月14日
 */
public class Test3 {
    public static void main(String[] args) {
        Flux<Integer> ints = Flux.range(1, 40);
        ints.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"),
                sub -> sub.request(10));
    }
}
