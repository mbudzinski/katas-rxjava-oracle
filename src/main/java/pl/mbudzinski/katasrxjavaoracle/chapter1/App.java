package pl.mbudzinski.katasrxjavaoracle.chapter1;


public class App {

    public static void main(String[] args) {
        ReactiveOracle reactiveOracle = new ReactiveOracle();

        reactiveOracle.answer()
                      .blockingSubscribe(System.out::println);
    }
}
