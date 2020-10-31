package com.jin.reactor.demo;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * @author wu.jinqing
 * @date 2020年10月10日
 */
public class Test30 {
    public static void main(String[] args) {
        StepVerifier.create(Flux.just("a", "b"))
                .expectNext("a")
                .expectNext("b")
                .verifyComplete();
    }
}
