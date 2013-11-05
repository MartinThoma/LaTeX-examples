/**
 * This class represents a digital camera with an autofocus feature.
 *
 * @author Markus Iser, Martin Thoma
 *
 */
public class Camera {
    /** This epsilon is used for internal float comparisons. */
    private static final double EPSILON = 1E-6;

    /** The objective that is currently used by the camera. */
    private final Objective objective;

    /**
     * The constructor for objective.
     *
     * @param objective
     *            an objective
     */
    public Camera(final Objective objective) {
        this.objective = objective;
    }

    /**
     * Check two doubles for equality.
     *
     * @param fp1 first floating point number
     * @param fp2 second floating point number
     * @return {@code true} if both floats are equal, otherwise {@code false}
     */
    private boolean fpEquals(final double fp1, final double fp2) {
        return Math.abs(fp1 - fp2) < EPSILON;
    }

    /**
     * Determine if the contrast on the left is higher than on the current
     * position.
     *
     * @param objective the objective you are manipulating
     * @return {@code true} the contrast on the left of the current position is
     *         higher, otherwise {@code false}
     */
    private boolean isLeftContrastHigher(Objective objective) {
        double contrast = objective.getContrast();
        objective.stepLeft();
        double contrastNew = objective.getContrast();
        objective.stepRight();

        // check if the contrast - according to our EPSILON - is the same
        if (fpEquals(contrast, contrastNew)) {
            return false;
        }

        return contrastNew > contrast;
    }

    /**
     * Adjust objective to get the optimum focus. The optimum focus is
     * determined by the highest contrast.
     */
    public void autofocus() {
        boolean stepLeft;
        double contrast = objective.getContrast();

        // determine direction
        stepLeft = isLeftContrastHigher(objective);

        // loop until optimum passed
        while (objective.getContrast() > contrast
                && !fpEquals(contrast, objective.getContrast())) {
            contrast = objective.getContrast();
            if (stepLeft) {
                objective.stepLeft();
            } else {
                objective.stepRight();
            }
        }

        // optional correction-move back
        if (!fpEquals(contrast, objective.getContrast())) {
            if (stepLeft) {
                objective.stepRight();
            } else {
                objective.stepLeft();
            }
        }
    }
}

