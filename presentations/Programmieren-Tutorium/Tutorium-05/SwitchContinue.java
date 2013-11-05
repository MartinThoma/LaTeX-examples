public class SwitchContinue {
    enum Direction {
        RECHTS, UNTEN, OBEN, LINKS
    }

    public static void main(String[] args) {
        Direction direction = Direction.RECHTS;

        switch (direction) {
        case RECHTS:
            direction = Direction.UNTEN;
            continue;
        case UNTEN:
            direction = Direction.LINKS;
            break;
        }
    }
}
