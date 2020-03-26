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

        assertFalse(offByOne.equalChars('1', '3'));
        assertFalse(offByOne.equalChars('A', 'a'));
        assertFalse(offByOne.equalChars('A', 'C'));
        assertTrue(offByOne.equalChars('`', 'a'));
        assertTrue(offByOne.equalChars('z', '{'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('x', 'y'));
        assertTrue(offByOne.equalChars('z', 'y'));

    }
}
