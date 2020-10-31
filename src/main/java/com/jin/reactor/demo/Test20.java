package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * @author wu.jinqing
 * @date 2020年10月09日
 */
public class Test20 {
    public static void main(String[] args) {
        Flux.range(1, 100).reduce((x, y) -> x + y).subscribe(System.out::println);
        Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);
    }
}
