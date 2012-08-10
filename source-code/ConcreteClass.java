import java.util.LinkedList;

public class ConcreteClass extends AbstractClass {
    @Override
    int simpleOperation1() {
        return 5;
    }

    @Override
    int simpleOperation2() {
        return 7;
    }

    public void testMe(int aVariable, double bT, LinkedList<Integer> c) {
        System.out.println("Test!" + aVariable + bT + c);
    }
}
