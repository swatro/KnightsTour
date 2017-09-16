import java.util.ArrayList;
import java.util.List;

public class Square {
    private final int horizontalIndex;
    private final int verticalIndex;
    private final List<Square> visited;

    Square(int horizontalIndex, int verticalIndex, List<Square> visited) {
        this.horizontalIndex = horizontalIndex;
        this.verticalIndex = verticalIndex;
        this.visited = visited;
    }

    int getVerticalIndex() {
        return verticalIndex;
    }

    int getHorizontalIndex() {
        return horizontalIndex;
    }

    boolean isValidMove(Move move) {
        int horizontal = move.getIncrementalHorizontal() + horizontalIndex;
        int vertical = move.getIncrementVertical() + verticalIndex;
        boolean isValidDimensions = horizontal >= 0 && vertical >= 0;

        Square square = new Square(horizontal, vertical, new ArrayList<>());
        return isValidDimensions && !visited.contains(square);
    }

    Square move(Move move) {
        int horizontal = move.getIncrementalHorizontal() + this.horizontalIndex;
        int vertical = move.getIncrementVertical() + this.verticalIndex;
        return new Square(horizontal, vertical, new ArrayList<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (horizontalIndex != square.horizontalIndex) return false;
        return verticalIndex == square.verticalIndex;
    }

    Square createSquareWithAttempted(Square square) {
        List<Square> visited = this.visited;
        visited.add(square);
        return new Square(horizontalIndex, verticalIndex, visited);
    }
}
