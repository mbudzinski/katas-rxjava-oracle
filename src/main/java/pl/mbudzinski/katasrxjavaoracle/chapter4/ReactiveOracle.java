package pl.mbudzinski.katasrxjavaoracle.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ReactiveOracle {


    private List<String> answers;

    public static final String YES_ANSWER = "Yes.";
    public static final String NO_ANSWER = "No.";

    private static final int MAX_DELAY = 3000;

    private Random random;

    public ReactiveOracle() {
       answers = new ArrayList<>();
       answers.add(YES_ANSWER);
       answers.add(NO_ANSWER);
       random = new Random();
    }

    public Observable<String> answer() {
        return Observable.interval(0, random.nextInt(MAX_DELAY), TimeUnit.MILLISECONDS)
                .flatMap(irrelevant -> Observable.just(getRandomAnswer()).delay(random.nextInt(MAX_DELAY), TimeUnit.MILLISECONDS));
    }

    private String getRandomAnswer() {
        return answers.get(random.nextInt(answers.size()));
    }


}
