package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * @author wu.jinqing
 * @date 2020年10月09日
 */
public class Test17 {
    public static void main(String[] args) {
        Flux.range(0, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);


    }
}
