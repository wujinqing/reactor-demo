package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * Flux.generate： 同步的，一个接一个的发射数据
 *
 *
 * This is for synchronous and one-by-one emissions,
 * @author wu.jinqing
 * @date 2020年09月16日
 */
public class Test5 {
    public static void main(String[] args) {
        Flux<String> flux = Flux.generate(
                () -> 0, // 初始state值
                (state, sink) -> {
            // 发射数据
            sink.next("3 x " + state + " = " + 3*state);

            if(10 == state)
            {
                sink.complete();// 类似递归的出口
            }

            return state + 1;// 产生一个新的state值
        });

        flux.subscribe(System.out::println);
        flux.subscribe(System.out::println);
    }
}
