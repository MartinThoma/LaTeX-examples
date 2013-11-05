public class World {
    public static void main(String[] args) {
        BikeStorage ladenLutz = new BikeStorage();

        Bike a = new Bike("a");
        Bike b = new Bike("b");
        Bike c = new Bike("c");
        Bike d = new Bike("d");

        ladenLutz.printBikes();

        ladenLutz.add(a);
        ladenLutz.printBikes();
        ladenLutz.add(b);
        ladenLutz.printBikes();

        ladenLutz.add(c);
        System.out.println("c wurde hinzugefügt:");
        ladenLutz.printBikes();
        ladenLutz.remove(c);
        System.out.println("c wurde entfernt:");
        ladenLutz.printBikes();
        ladenLutz.add(d);
        ladenLutz.add(a);

        ladenLutz.printBikes();
    }
}
