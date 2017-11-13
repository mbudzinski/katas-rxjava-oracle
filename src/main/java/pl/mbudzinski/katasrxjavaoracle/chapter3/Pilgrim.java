package pl.mbudzinski.katasrxjavaoracle.chapter3;

import io.reactivex.Observable;

public class Pilgrim {

    public Observable<String> ask(ReactiveOracle reactiveOracle) {

        return reactiveOracle.answer();
    }


}
