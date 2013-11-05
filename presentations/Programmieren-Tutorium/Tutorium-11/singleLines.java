public final class Math {

    /**
     * Don't let anyone instantiate this class.
     */
    private Math() {}

public class Main {
    public static void main(String[] args) {
        Apple myApple = new Apple();
        if (myApple instanceof Fruit) {
            System.out.println("It's true!");
        }
    }
}

if (this.getClass() != other.getClass())
    return false;
