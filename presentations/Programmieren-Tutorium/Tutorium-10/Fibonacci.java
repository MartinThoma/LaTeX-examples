import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private final Map<Integer, Integer> functionValues;

    public Fibonacci() {
        functionValues = new HashMap<Integer, Integer>();
        functionValues.put(0, 0);
        functionValues.put(1, 1);
    }

    private int calculate(int x) {
        return getFunctionValue(x - 1) + getFunctionValue(x - 2);
    }

    public int getFunctionValue(int x) {
        if (x < 0) {
            /* Exception werfen */
            throw new IllegalArgumentException(
                    "Fibonacci is not defined for negative values");
        }

        if (functionValues.containsKey(x)) {
            return functionValues.get(x);
        } else {
            int functionValue = calculate(x);
            functionValues.put(x, functionValue);
            return functionValue;
        }
    }
}
