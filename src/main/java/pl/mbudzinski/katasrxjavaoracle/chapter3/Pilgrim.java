package pl.mbudzinski.katasrxjavaoracle.chapter3;

import io.reactivex.Observable;
import pl.mbudzinski.katasrxjavaoracle.chapter2.ReactiveOracle;

public class Pilgrim {

    public Observable<String> ask(ReactiveOracle reactiveOracle) {
        return Observable.just(reactiveOracle.answer().blockingFirst());
    }

}
