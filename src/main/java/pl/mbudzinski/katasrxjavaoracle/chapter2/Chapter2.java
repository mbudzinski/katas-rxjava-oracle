package pl.mbudzinski.katasrxjavaoracle.chapter2;


import io.reactivex.Observable;

public class Chapter2 {

    public static void main(String[] args) {
        ReactiveOracle reactiveOracle = new ReactiveOracle();
        Pilgrim pilgrim = new Pilgrim();

        Observable<String> firstAnswer = pilgrim.ask(reactiveOracle);
        Observable<String> secondAnswer = pilgrim.ask(reactiveOracle);

        Observable<String> firstAndSecond = firstAnswer.mergeWith(secondAnswer);

        Observable<String> thirdAnswer = pilgrim.ask(reactiveOracle);

        Observable<String> allAnswers = firstAndSecond.mergeWith(thirdAnswer);
        allAnswers.blockingSubscribe(System.out::println);
    }
}
