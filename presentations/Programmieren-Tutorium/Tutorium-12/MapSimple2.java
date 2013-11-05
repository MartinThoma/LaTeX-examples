import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Person, TelephoneNumber> phonebook =
            new HashMap<Person, TelephoneNumber>();

        TelephoneNumber a = new TelephoneNumber("01636280491");
        phonebook.put(new Person("Martin", "Thoma"), a);
        phonebook.put(new Person("Max", "Mustermann"), a);
        System.out.println(phonebook);
    }
}
