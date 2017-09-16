import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChessBoardTest {

    @Test
    public void run8x8() throws Exception {
        ChessBoard chessBoard = new ChessBoard(8, 8);
        List<Square> visited = chessBoard.tour();

        Square secondSquare = visited.get(0);
        assertThat(secondSquare.getVerticalIndex(), is(0));
        assertThat(secondSquare.getHorizontalIndex(), is(0));
    }

    @Test
    public void knightFirstSquareShouldBeZeroZero() throws Exception {
        ChessBoard chessBoard = new ChessBoard(5, 5);
        List<Square> visited = chessBoard.tour();

        Square secondSquare = visited.get(0);
        assertThat(secondSquare.getVerticalIndex(), is(0));
        assertThat(secondSquare.getHorizontalIndex(), is(0));
    }

    @Test
    public void knightShouldVisitTwoSquares() throws Exception {
        ChessBoard chessBoard = new ChessBoard(5, 5);
        List<Square> visited = chessBoard.tour();

        Square secondSquare = visited.get(1);
        assertThat(secondSquare.getHorizontalIndex(), is(2));
        assertThat(secondSquare.getVerticalIndex(), is(1));
    }

    @Test
    public void knightShouldVisitThreeSquares() throws Exception {
        ChessBoard chessBoard = new ChessBoard(5, 5);
        List<Square> visited = chessBoard.tour();

        Square secondSquare = visited.get(2);
        assertThat(secondSquare.getHorizontalIndex(), is(4));
        assertThat(secondSquare.getVerticalIndex(), is(0));

    }

    @Test
    public void shouldNotGoOutSideChessBoard() throws Exception {
        ChessBoard chessBoard = new ChessBoard(5, 5);
        List<Square> visited = chessBoard.tour();

        Square square = visited.get(3);
        assertThat(square.getHorizontalIndex(), is(3));
        assertThat(square.getVerticalIndex(), is(2));
    }

    @Test
    public void shouldNotRepeatSquares() throws Exception {
        ChessBoard chessBoard = new ChessBoard(5, 5);
        List<Square> visited = chessBoard.tour();

        Square square = visited.get(4);
        assertThat(square.getHorizontalIndex(), is(4));
        assertThat(square.getVerticalIndex(), is(4));
    }
}