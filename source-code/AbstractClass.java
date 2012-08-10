public class AbstractClass {
    int templateMethod() {
        return simpleOperation1() * simpleOperation2();
    }

    int simpleOperation1() {
        return 2;
    }

    int simpleOperation2() {
        return 3;
    }
}
