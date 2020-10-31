package com.jin.reactor.demo;

import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

/**
 * @author wu.jinqing
 * @date 2020年10月10日
 */
public class Test32 {
    public static void main(String[] args) {
        final TestPublisher<String> testPublisher = TestPublisher.create();
        testPublisher.next("a");
        testPublisher.next("b");
        testPublisher.complete();

        StepVerifier.create(testPublisher)
                .expectNext("a")
                .expectNext("b")
                .expectComplete();
    }
}
