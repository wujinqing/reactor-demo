package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * @author wu.jinqing
 * @date 2020年10月09日
 */
public class Test19 {
    public static void main(String[] args) {
        Flux.range(1, 1000).take(10).subscribe(System.out::println);
        System.out.println("=");
        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
        System.out.println("==");
        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
        System.out.println("===");
        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);
    }
}
