import java.util.Comparator;
 
public class PopulationDensityComperator implements
        Comparator<Country> {
 
    @Override
    public int compare(Country o1, Country o2) {
        double o1Density = o1.population / o1.area;
        double o2Density = o2.population / o2.area;
 
        if (Math.abs(o1Density - o2Density) < 0.00001) {
            return 0;
        } else {
            return o1Density - o2Density;
        }
    }
 
}
