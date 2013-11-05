/**
 * A bike model in Java. This class models the wheels.
 *
 * @author Markus Iser, Martin Thoma
 * @version 1.0
 */

class Wheels {
    public static final int MIN_DIAMETER = 150;
    public static final int MAX_DIAMETER = 700;
    public static final int MIN_WHEEL_SIZE = 20;
    public static final int MAX_WHEEL_SIZE = 50;

    /** The diameter is in range MIN_DIAMETER to MAX_DIAMETER. */
    private int diameter = 559;

    /** The wheelsSize is in range MIN_WHEEL_SIZE to MAX_WHEEL_SIZE. */
    private double wheelsSize = 50;

    /** Price measured in Euro-cents. */
    private final int price;

    Wheels(int diameter, double wheelSize, int price) {
        this.diameter = diameter;
        this.wheelsSize = wheelSize;
        this.price = price;
    }

    /**
     * @return the price of the wheels in cent
     */
    int getPrice() {
        return price;
    }

    /**
     * @return the diameter in mm
     */
    public int getDiameter() {
        return this.diameter;
    }

    /**
     * @return the size of the wheel in mm
     */
    public double getWheelsSize() {
        return this.wheelsSize;
    }
}