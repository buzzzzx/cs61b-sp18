import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        boolean actual1 = offByOne.equalChars('a', 'b');
        boolean actual2 = offByOne.equalChars('r', 'q');
        boolean actual3 = offByOne.equalChars('a', 'z');
        boolean actual4 = offByOne.equalChars('d', 'd');
        boolean actual5 = offByOne.equalChars('&', '%');
        boolean actual6 = offByOne.equalChars('B', 'a');

        assertTrue(actual1);
        assertTrue(actual2);
        assertTrue(actual5);
        assertFalse(actual3);
        assertFalse(actual4);
        assertFalse(actual6);

    }
}
