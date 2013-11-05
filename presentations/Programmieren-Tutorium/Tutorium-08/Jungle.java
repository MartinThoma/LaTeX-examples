public class Jungle {
    public static void main(String[] args) {
        Animal tigger = new Tiger();
        Animal felix = new Cat();
        Cat ninja = new Cat();
        Tiger diego = new Tiger();

        tigger.roar();
        felix.roar();
        ninja.roar();
        diego.roar();
        diego.sound = "Hust hust";
        diego.roar();
    }
}
