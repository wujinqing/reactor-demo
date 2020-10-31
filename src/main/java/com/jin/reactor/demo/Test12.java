package com.jin.reactor.demo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * @author wu.jinqing
 * @date 2020年09月17日
 */
public class Test12 {
    public static void main(String[] args) {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        final Flux<String> flux = Flux
                .range(1, 2)
                .map(i -> 10 + i) // 都在Scheduler s 线程池中执行
                .subscribeOn(s) // 改变了全局的线程池
                .map(i -> "value " + i);// 都在Scheduler s 线程池中执行

        new Thread(() -> flux.subscribe(System.out::println)).start();
    }
}
