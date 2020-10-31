package com.jin.reactor.demo;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * @author wu.jinqing
 * @date 2020年10月10日
 */
public class Test31 {
    public static void main(String[] args) {
        StepVerifier.withVirtualTime(() -> Flux.interval(Duration.ofHours(4), Duration.ofDays(1)).take(2))
                .expectSubscription()
                .expectNoEvent(Duration.ofHours(4))
                .expectNext(0L)
                .thenAwait(Duration.ofDays(1))
                .expectNext(1L)
                .verifyComplete();
    }
}
