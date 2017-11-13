package pl.mbudzinski.katasrxjavaoracle.chapter3;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Chapter3 {

    public static void main(String[] args) {
        ReactiveOracle reactiveOracle = new ReactiveOracle();
        Pilgrim pilgrim = new Pilgrim();

        Observable.merge(
                pilgrim.ask(reactiveOracle),
                pilgrim.ask(reactiveOracle),
                pilgrim.ask(reactiveOracle)
        ).subscribeOn(Schedulers.trampoline()).blockingSubscribe(System.out::println);

    }

}
