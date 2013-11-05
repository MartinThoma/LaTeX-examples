import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> europe = new ArrayList<Country>();
        europe.add(new Country(81903000,357121.41,"Germany"));
        europe.add(new Country(64667000,668763, "France"));
        europe.add(new Country( 4985900,385199, "Norway"));
        europe.add(new Country( 9514406,450295, "Sweden"));
        europe.add(new Country(47212990,504645, "Spain"));
        europe.add(new Country( 8014000, 41285, "Switzerland"));
        europe.add(new Country(   36371,     2.02, "Monaco"));
        System.out.println(europe);
        Collections.sort(europe);
        System.out.println(europe);
        Collections.sort(europe, new PopulationDensityComperator());
        System.out.println(europe);
    }
}
