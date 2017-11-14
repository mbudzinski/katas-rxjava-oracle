package pl.mbudzinski.katasrxjavaoracle.chapter4;

import io.reactivex.Observable;

public class King {

    private static final String QUESTION = "Should I raise taxes?";

    public Observable<String> ask(ReactiveOracle reactiveOracle) {
        System.out.println(QUESTION);
        return reactiveOracle.answer();
    }


}
