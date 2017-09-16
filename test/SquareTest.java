import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void shouldBeEqualWhenCordinatesAreEqual() throws Exception {
        List<Square> visited = new ArrayList<Square>();
        Square firstSquare = new Square(1, 3, visited);
        Square secondSquare = new Square(1, 3, visited);
        assertThat(firstSquare.equals(secondSquare), is(true));
    }

    @Test
    public void contains() throws Exception {
        List<Square> visited = new ArrayList<Square>();

        Square firstSquare = new Square(1, 3, visited);
        Square secondSquare = new Square(1, 3, visited);
        List<Square> squares = Arrays.asList(firstSquare);
        assertThat(squares.contains(secondSquare), is(true));
    }
}