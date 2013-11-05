import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fruit> myFruits = new LinkedList<Fruit>();
        List<Apple> myApples = new LinkedList<Apple>();

        myFruits.add(new Fruit());
        myFruits.add(new Apple());

        myApples.add(new Apple());

        System.out.println(myFruits.getClass());
        System.out.println(myApples.getClass());
        myFruits = myApples;
    }
}
