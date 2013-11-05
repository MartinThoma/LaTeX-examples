public class Person {
    String prename;
    String surname;

    public Person(String prename, String surname) {
        super();
        this.prename = prename;
        this.surname = surname;
    }

    @Override
    public void shout() {
        System.out.println("AAAAAAAAAAAAARGH!");
    }
}
