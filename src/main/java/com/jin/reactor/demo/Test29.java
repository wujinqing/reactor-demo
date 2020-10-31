package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author wu.jinqing
 * @date 2020年10月10日
 */
public class Test29 {
    public static void main(String[] args) throws Exception {
        final Flux<Long> source = Flux.interval(Duration.ofMillis(1000))
                .take(10)
                .publish()
                .autoConnect();
        source.subscribe();
        Thread.sleep(5000);
        source
                .toStream()
                .forEach(System.out::println);
    }
}
