package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * @author wu.jinqing
 * @date 2020年10月09日
 */
public class Test18 {
    public static void main(String[] args) {
        Flux.range(1, 100).window(20).subscribe(System.out::println);
//        Flux.intervalMillis(100).windowMillis(1001).take(2).toStream().forEach(System.out::println);
    }
}
