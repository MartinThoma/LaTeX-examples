import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<? extends Fruit> apples = new LinkedList<Apple>();

        // I can't get apples in
        // this gives an error
        apples.add(new Apple());
        // In fact, you can only add null!
    }
}
