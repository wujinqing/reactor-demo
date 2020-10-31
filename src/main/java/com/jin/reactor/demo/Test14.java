package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * @author wu.jinqing
 * @date 2020年09月25日
 */
public class Test14 {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("Hello", "World", "Hello World");

        System.out.println(flux.getClass());
        flux.subscribe(System.out::println);
    }
}
