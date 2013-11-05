public class World {
    public static void main(String[] args) {
        Baby alice = new Baby("Alice");
        alice.size = 42;

        Baby bob = new Baby("Bob");
        bob.size = 56;

        System.out.println("Alice: " + alice.size);
        System.out.println("Bob: " + bob.size);
    }
}
