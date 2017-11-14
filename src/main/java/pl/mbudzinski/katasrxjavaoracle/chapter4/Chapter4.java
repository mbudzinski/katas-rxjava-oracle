package pl.mbudzinski.katasrxjavaoracle.chapter4;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class Chapter4 {

    private static List<ReactiveOracle> oracles = new ArrayList<>();

    public static void main(String[] args) {

        King king = new King();

        Observable.range(0, 3).forEach(index -> oracles.add(new ReactiveOracle())).dispose();

        Observable.merge(
                king.ask(oracles.get(0)).take(1),
                king.ask(oracles.get(1)).take(1),
                king.ask(oracles.get(2)).take(1)
        ).groupBy(answer -> {
            if (answer.equals(ReactiveOracle.YES_ANSWER)) {
                return ReactiveOracle.YES_ANSWER;
            } else {
                return ReactiveOracle.NO_ANSWER;
            }
        }).subscribe(group -> group.subscribe(x -> {

        }));
    /*        boolean shouldTaxesBeRaised = yesAnswers > oracles.size() / 2;
            if (shouldTaxesBeRaised) {
                System.out.println(ReactiveOracle.YES_ANSWER);
            } else {
                System.out.println(ReactiveOracle.NO_ANSWER);
            }
        });*/
    }

}
