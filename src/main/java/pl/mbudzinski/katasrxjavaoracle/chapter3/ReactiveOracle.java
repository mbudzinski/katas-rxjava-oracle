package pl.mbudzinski.katasrxjavaoracle.chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ReactiveOracle {


    private Map<Integer, String> answerMap;

    public ReactiveOracle() {
        answerMap = new HashMap<>();
        answerMap.put(0, "Insanity: doing the same thing over and over again and expecting different results.");
        answerMap.put(1, "A person who never made a mistake never tried anything new.");
        answerMap.put(2, "Gravitation is not responsible for people falling in love.");
        answerMap.put(3, "Look deep into nature, and then you will understand everything better.");
    }

    public Observable<String> answer() {
        Random random = new Random();
        return Observable.interval(random.nextInt(3000), TimeUnit.MILLISECONDS)
                .concatMap(interval -> Observable.just(answerMap.get(random.nextInt(answerMap.size())))
                        .delay(random.nextInt(3000), TimeUnit.MILLISECONDS)
                );
    }


}
