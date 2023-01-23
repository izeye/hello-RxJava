package com.izeye.helloworld;

import io.reactivex.rxjava3.core.Flowable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Hello world for RxJava.
 *
 * @author Johnny Lim
 */
public class Main {
    public static void main(String[] args) {
        Flowable.just("Hello, RxJava!").subscribe(System.out::println);
        Flowable.just(1, 2).subscribe(System.out::println);
        Flowable.just(1, 2).map(i -> i * 2).subscribe(System.out::println);
        Flowable.just(1, 2).flatMap(i -> Flowable.just(i * 2, i * 20)).subscribe(System.out::println);
        Flowable.intervalRange(1, 10, 500, 500, TimeUnit.MILLISECONDS)
                .blockingSubscribe(System.out::println);

        Random random = new Random();

        Flowable.intervalRange(1, 10, 100, 100, TimeUnit.MILLISECONDS)
                .flatMap(i -> Flowable.just(i * 10).delay(random.nextInt(500), TimeUnit.MILLISECONDS))
                .blockingSubscribe(System.out::println);

        Flowable.intervalRange(1, 10, 500, 500, TimeUnit.MILLISECONDS)
                .concatMap(i -> Flowable.just(i * 10).delay(random.nextInt(500), TimeUnit.MILLISECONDS))
                .blockingSubscribe(System.out::println);
    }
}
