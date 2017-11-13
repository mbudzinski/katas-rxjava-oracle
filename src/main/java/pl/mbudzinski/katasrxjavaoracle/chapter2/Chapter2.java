package pl.mbudzinski.katasrxjavaoracle.chapter2;


import io.reactivex.Observable;

public class Chapter2 {

    public static void main(String[] args) {
        ReactiveOracle reactiveOracle = new ReactiveOracle();
        Pilgrim pilgrim = new Pilgrim();

        Observable.merge(
                pilgrim.ask(reactiveOracle),
                pilgrim.ask(reactiveOracle),
                pilgrim.ask(reactiveOracle)
        ).blockingSubscribe(System.out::println);
    }
}
