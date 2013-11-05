import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<? super Apple> apples = new LinkedList<Fruit>();
        apples.add(new Apple());

        // I can't get apples out
        for (Object o : apples) {
            Apple a = (Apple) o;
            System.out.println(a);
        }
    }
}
