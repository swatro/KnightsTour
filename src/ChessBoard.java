import java.util.*;

class ChessBoard {
    private final int numberOfRows;
    private final int numberOfColumns;

    ChessBoard(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    List<Square> tour() {
        LinkedList<Square> knights = new LinkedList<>();
        knights.add(new Square(0, 0, new ArrayList<>()));

        while (knights.size() < (numberOfColumns * numberOfRows)) {
            Square lastSquare = knights.getLast();
            Optional<Move> potentialMove = getMoveKnight(lastSquare, knights);
            if (potentialMove.isPresent()) {
                Move move = potentialMove.get();
                knights.addLast(lastSquare.move(move));
            } else {
                Square square = knights.pollLast();
                Square last = knights.pollLast();
                knights.add(last.createSquareWithAttempted(square));
            }

        }
        print(knights);
        return knights;
    }

    private Optional<Move> getMoveKnight(Square square, LinkedList<Square> knights) {
        return Move.moves
                .stream()
                .filter(move -> square.isValidMove(move) && isValidMoveForBoard(square, knights, move))
                .findFirst();
    }

    private boolean isValidMoveForBoard(Square square, LinkedList<Square> knights, Move move) {
        Square potentialSquare = square.move(move);
        return isSquareOnBoard(potentialSquare) && !knights.contains(potentialSquare);
    }

    private boolean isSquareOnBoard(Square potentialSquare) {
        return potentialSquare.getVerticalIndex() < numberOfRows && potentialSquare.getHorizontalIndex() < numberOfColumns;
    }

    private void print(List<Square> knights) {
        System.out.println("Run finished with " + knights.size() + " squares visited.");
        knights.forEach(x -> System.out.println(x.getHorizontalIndex() + ", " + x.getVerticalIndex()));
    }
}
