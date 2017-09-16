import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Move {

    FIRST_MOVE(1, -2),
    SECOND_MOVE(2, -1),
    THIRD_MOVE(2, 1),
    FOURTH_MOVE(1, 2),
    FIFTH_MOVE(-1, 2),
    SIXTH_MOVE(-2, 1),
    SEVENTH_MOVE(-2, -1),
    EIGHT_MOVE(-1, -2);

    private final int incrementalHorizontal;
    private final int incrementVertical;

    Move(int incrementHorizontal, int incrementVertical) {
        this.incrementalHorizontal = incrementHorizontal;
        this.incrementVertical = incrementVertical;
    }

    public int getIncrementalHorizontal() {
        return incrementalHorizontal;
    }

    public int getIncrementVertical() {
        return incrementVertical;
    }

    public static List<Move> moves = Arrays.asList(FIRST_MOVE, SECOND_MOVE, THIRD_MOVE, FOURTH_MOVE, FIFTH_MOVE, SIXTH_MOVE, SEVENTH_MOVE, EIGHT_MOVE);
}
