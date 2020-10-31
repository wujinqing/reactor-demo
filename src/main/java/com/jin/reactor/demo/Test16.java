package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * @author wu.jinqing
 * @date 2020年10月09日
 */
public class Test16 {
    public static void main(String[] args) {
        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
//        Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System .out::println);
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);

    }
}
