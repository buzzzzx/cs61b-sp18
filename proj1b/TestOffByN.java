import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        boolean actual1 = offByN.equalChars('a', 'f');
        boolean actual2 = offByN.equalChars('f', 'a');
        boolean actual3 = offByN.equalChars('a', 'z');
        boolean actual4 = offByN.equalChars('d', 'd');
        boolean actual5 = offByN.equalChars('g', 'l');

        assertTrue(actual1);
        assertTrue(actual2);
        assertTrue(actual5);
        assertFalse(actual3);
        assertFalse(actual4);

    }
}
