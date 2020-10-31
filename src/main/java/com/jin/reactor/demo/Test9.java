package com.jin.reactor.demo;

import reactor.core.publisher.Mono;

/**
 * @author wu.jinqing
 * @date 2020年09月16日
 */
public class Test9 {
    public static void main(String[] args) throws Exception{
        final Mono<String> mono = Mono.just("hello");

        Thread t = new Thread(() -> {
            mono.map(msg -> msg + " thread ").subscribe(m -> System.out.println(m + Thread.currentThread().getName()));
        });

        t.start();
        t.join();
    }
}
