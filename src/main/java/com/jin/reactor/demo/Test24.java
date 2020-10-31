package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;

/**
 * @author wu.jinqing
 * @date 2020年10月09日
 */
public class Test24 {
    public static void main(String[] args) {
        Flux.combineLatest(
                Arrays::toString,
                Flux.interval(Duration.ofMillis(100)).take(5),
                Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5)
        ).toStream().forEach(System.out::println);
    }
}
