package com.jin.reactor.demo;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

/**
 * @author wu.jinqing
 * @date 2020年09月14日
 */
public class SampleSubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscription");
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value);
        request(1);
    }
}
