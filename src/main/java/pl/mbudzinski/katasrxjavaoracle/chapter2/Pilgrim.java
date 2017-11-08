package pl.mbudzinski.katasrxjavaoracle.chapter2;

import io.reactivex.Observable;

public class Pilgrim {

    public Observable<String> ask(ReactiveOracle reactiveOracle) {
        return Observable.just(reactiveOracle.answer().blockingFirst());
    }

}
