package com.jin.reactor.demo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author wu.jinqing
 * @date 2020年10月09日
 */
public class Test28 {
    public static void main(String[] args) {
        Flux.create(sink -> {
            sink.next(Thread.currentThread().getName());
            sink.complete();
        })
                .publishOn(Schedulers.single())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .publishOn(Schedulers.elastic())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .subscribeOn(Schedulers.parallel())
                .toStream()
                .forEach(System.out::println);
    }
}
