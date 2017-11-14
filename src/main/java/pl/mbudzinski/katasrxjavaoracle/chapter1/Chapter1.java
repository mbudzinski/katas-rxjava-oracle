package pl.mbudzinski.katasrxjavaoracle.chapter1;


public class Chapter1 {

    public static void main(String[] args) {
        ReactiveOracle reactiveOracle = new ReactiveOracle();

        System.out.println(reactiveOracle.answer().blockingFirst());

    }
}
