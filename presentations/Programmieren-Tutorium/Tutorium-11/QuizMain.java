import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> myList = new LinkedList<List<String>>();
        List<String> list1 = new LinkedList<String>();
        myList.add(list1);

        list1.add("I");
        list1.add("think");
        list1.add("therefore");
        list1.add("I");
        list1.add("am");

        System.out.println(myList);
        Collections.sort(myList);
        System.out.println(myList);
    }
}
