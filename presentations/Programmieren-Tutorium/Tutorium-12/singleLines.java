LinkedList<MyType> myList = new LinkedList<MyType>();
List<MyType> myList = new LinkedList<MyType>();
import java.util.List;

Animal a = new Animal();
// The compiler can resolve this method call statically:
a.Roar();

public void MakeSomeNoise(object a) {
    // Things happen...
    // You won't know if this works until runtime:
    ((Animal) a).Roar(); 
}

for (Map.Entry<Person, TelephoneNumber> 
        entry : phonebook.entrySet()) {
    Person k = entry.getKey();
    TelephoneNumber v = entry.getValue();
    System.out.println(k + " " + v);
}
