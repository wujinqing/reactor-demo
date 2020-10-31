package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author wu.jinqing
 * @date 2020年10月09日
 */
public class Test21 {
    public static void main(String[] args) {
        Flux.merge(Flux.interval(Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
                .toStream()
                .forEach(System.out::println);
        Flux.mergeSequential(Flux.interval(Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(50),Duration.ofMillis(100)).take(5))
                .toStream()
                .forEach(System.out::println);
    }
}
