package com.jin.reactor.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author wu.jinqing
 * @date 2020年10月09日
 */
public class Test26 {
    public static void main(String[] args) {
        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .onErrorReturn(0)
                .subscribe(System.out::println);

    }
}
