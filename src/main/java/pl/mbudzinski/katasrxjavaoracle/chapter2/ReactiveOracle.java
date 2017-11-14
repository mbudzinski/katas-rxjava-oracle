package pl.mbudzinski.katasrxjavaoracle.chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ReactiveOracle {

    private List<String> answers;

    private Random random;

    private static int MAX_DELAY = 3000;

    public ReactiveOracle() {
        answers = Arrays.asList(
                "Insanity: doing the same thing over and over again and expecting different results.",
                "A person who never made a mistake never tried anything new.",
                "Gravitation is not responsible for people falling in love.",
                "Look deep into nature, and then you will understand everything better."
        );
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
