List<?> myList = new LinkedList<Fruit>();
myList.add(null); // ok
myList.add(new Fruit()); // Compiler error

try {
    // your code
} catch (Exception ex) {
   // Gotcha!
}

/* *
 * The foo method.
 *
 * @throws UniverseExplodeException when the universe
 *         is going to explode
 */
public void foo() throws UniverseExplodeException {
    if (true) {
        throw new UniverseExplodeException();
    }
}

/**
 * Generic version of the Box class.
 * 
 * @param <T> the type of the value being boxed
 */
public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
