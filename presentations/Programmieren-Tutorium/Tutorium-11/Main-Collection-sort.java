import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
 
public class Main {
    public static void main(String[] args) {
        List<String> myList = new LinkedList<String>();
        myList.add("I");
        myList.add("think");
        myList.add("therefore");
        myList.add("I");
        myList.add("am");

        System.out.println(myList);
        Collections.sort(myList);
        System.out.println(myList);
    }
}
