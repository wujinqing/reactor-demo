package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author wu.jinqing
 * @date 2020年09月17日
 */
public class Test10 {
    public static void main(String[] args) throws Exception{
        Flux<Long> flux = Flux.interval(Duration.ofMillis(300));


        new Thread(() -> flux.subscribe(System.out::println)).start();

        Thread.sleep(60000);
    }
}
