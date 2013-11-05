/**
 * This class models the gears. It is restricted to derailleur gears.
 *
 * @author Markus Iser, Martin Thoma
 * @version 1.0
 */

public class Gears {
    public static final int MIN_FRONT_SPROCKETS = 1;
    public static final int MAX_FRONT_SPROCKETS = 3;
    public static final int MIN_REAR_SPROCKETS = 1;
    public static final int MAX_REAR_SPROCKETS = 10;

    private int frontSprockets;
    private int rearSprockets;

    /** Price in cents. */
    private final int price;

    Gears(int frontSprockets, int rearSprockets, int price) {
        setSprockets(frontSprockets, rearSprockets);
        this.price = price;
    }

    /**
     * Sets the sprocket numbers. Uses default-values if consisteny criteria are
     * not met.
     *
     * @param sprockets
     * @param rearSprockets
     */
    void setSprockets(int sprockets, int rearSprockets) {
        this.frontSprockets = sprockets;
        this.rearSprockets = rearSprockets;

        if (!(this.frontSprockets >= 1)) { // A.1
            this.frontSprockets = 1;
        } else if (!(this.frontSprockets < 4)) { // A.2
            this.frontSprockets = 3;
        }

        if (this.rearSprockets < 1) { // B.1
            this.rearSprockets = this.frontSprockets;
        }
        if (this.rearSprockets > 9) { // B.2
            this.rearSprockets = this.frontSprockets * 3;
        }

        if (this.rearSprockets < this.frontSprockets) { // C.1
            this.rearSprockets = this.frontSprockets;
        } else if (this.rearSprockets > 3 * this.frontSprockets) { // C.2
            this.rearSprockets = 3 * this.frontSprockets;
        }
    }

    /**
     * @return the number of gears as the number of sprocket-combinations
     */
    int getNumberOfGears() {
        return frontSprockets * rearSprockets;
    }

    /**
     * @return the price of the gears
     */
    int getPrice() {
        return price;
    }
}
