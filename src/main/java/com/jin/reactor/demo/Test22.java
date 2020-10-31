package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author wu.jinqing
 * @date 2020年10月09日
 */
public class Test22 {
    public static void main(String[] args) {
        Flux.just(5, 10)
                .flatMap(x -> Flux.interval(Duration.ofMillis(x * 10), Duration.ofMillis(100)).take(x))
                .toStream()
                .forEach(System.out::println);
    }
}
