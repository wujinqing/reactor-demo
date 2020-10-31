package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wu.jinqing
 * @date 2020年09月16日
 */
public class Test6 {
    public static void main(String[] args) {
        Flux<String> flux = Flux.generate(AtomicLong::new, (state, sink) -> {
            long i = state.getAndIncrement();

            sink.next("3 x " + i + " = " + 3*i);

            if(10 == i)
            {
                sink.complete();// 类似递归的出口
            }

            return state;
        });

        flux.subscribe(System.out::println);
    }
}
