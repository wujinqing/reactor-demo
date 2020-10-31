package com.jin.reactor.demo;

import reactor.core.publisher.Flux;

/**
 * @author wu.jinqing
 * @date 2020年09月17日
 */
public class Test13 {
    public static void main(String[] args) {
        Flux<Integer> s = Flux.range(1, 10)
                .map(v -> doSomethingDangerous(v))
                .map(v -> doSecondTransform(v));
        s.subscribe(value -> System.out.println("RECEIVED " + value),
                error -> System.err.println("CAUGHT " + error)
        );


        /*
        Static Fallback Value: onErrorReturn

Flux.just(10)
    .map(this::doSomethingDangerous)
    .onErrorReturn("RECOVERED");



    Fallback Method: onErrorResume

    Flux.just("key1", "key2")
    .flatMap(k -> callExternalService(k)
        .onErrorResume(e -> getFromCache(k))
    );

Flux.just("timeout1", "unknown", "key2")
    .flatMap(k -> callExternalService(k)
        .onErrorResume(error -> {
            if (error instanceof TimeoutException)
                return getFromCache(k);
            else if (error instanceof UnknownKeyException)
                return registerNewEntry(k, "DEFAULT");
            else
                return Flux.error(error);
        })
    );



Dynamic Fallback Value


erroringFlux.onErrorResume(error -> Mono.just(
        MyWrapper.fromError(error)
));



Catch and Rethrow


Flux.just("timeout1")
    .flatMap(k -> callExternalService(k))
    .onErrorResume(original -> Flux.error(
            new BusinessException("oops, SLA exceeded", original))
    );



Flux.just("timeout1")
    .flatMap(k -> callExternalService(k))
    .onErrorMap(original -> new BusinessException("oops, SLA exceeded", original));



Log or React on the Side


LongAdder failureStat = new LongAdder();
Flux<String> flux =
Flux.just("unknown")
    .flatMap(k -> callExternalService(k)
        .doOnError(e -> {
            failureStat.increment();
            log("uh oh, falling back, service failed for key " + k);
        })

    );

Using Resources and the Finally Block


Stats stats = new Stats();
LongAdder statsCancel = new LongAdder();

Flux<String> flux =
Flux.just("foo", "bar")
    .doOnSubscribe(s -> stats.startTimer())
    .doFinally(type -> {
        stats.stopTimerAndRecordTiming();
        if (type == SignalType.CANCEL)
          statsCancel.increment();
    })
    .take(1);

Reactive try-with-resource: using()

Flux<String> flux =
Flux.using(
        () -> disposableInstance,
        disposable -> Flux.just(disposable.toString()),
        Disposable::dispose
);

         */
    }

    public static Integer doSomethingDangerous(Integer s)
    {
        if(s == 5)
        {
            throw new RuntimeException("ex 555");
        }
        return s ;
    }

    public static Integer doSecondTransform(Integer s)
    {
        return s;
    }
}
