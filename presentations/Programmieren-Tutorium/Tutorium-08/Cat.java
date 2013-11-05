public class Cat extends Animal {
    public String sound;

    public Cat() {
        String sound = "Maunz";
    }

    @Override
    public void roar() {
        System.out.println("Cat:" + sound);
    }
}
