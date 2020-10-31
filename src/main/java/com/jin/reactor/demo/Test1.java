package com.jin.reactor.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Test1 {
    public static void main(String[] args) {
        Flux<String> datas = Flux.just("foo", "bar", "foobar");
        List<String> iter = Arrays.asList("foo", "bar", "foobar");

        Flux<String> seq2 = Flux.fromIterable(iter);

        Mono<String> noData = Mono.empty();
        Mono<String> data = Mono.just("foo");

        Flux<Integer> numberFromFiveToSeven = Flux.range(5, 3);

        datas.subscribe(System.out::println);

        System.out.println("=================");
        Flux<Integer> ints = Flux.range(1, 3);
        ints.subscribe();
    }
}
