import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List; // nicht java.awt.List!

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        List<Integer> anotherList = new LinkedList<Integer>();

        for (int i = 0; i < 5; i += 1) {
            myList.add((int) (Math.random() * 100));
            anotherList.add((int) (Math.random() * 100));
        }

        System.out.println("myList: " + myList);
        System.out.println("anotherList: " + anotherList);

        myList.addAll(anotherList);
        Collections.sort(myList);
        System.out.println("combined: " + myList);

        for (int myInt : myList) {
            // do something with myInt...
        }
    }
}
