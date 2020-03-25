import org.junit.Test;


import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        Boolean actual1 = palindrome.isPalindrome("racecar");
        Boolean actual2 = palindrome.isPalindrome("murdrum");
        Boolean actual3 = palindrome.isPalindrome("horse");
        Boolean actual4 = palindrome.isPalindrome("");

        assertTrue(actual1);
        assertTrue(actual2);
        assertFalse(actual3);
        assertTrue(actual4);
    }

    @Test
    public void testIsPalindromeWithComparator() {
        CharacterComparator cc = new OffByOne();
        Boolean actual1 = palindrome.isPalindrome("flake", cc);
        Boolean actual2 = palindrome.isPalindrome("flakeaa", cc);
        Boolean actual3 = palindrome.isPalindrome("a", cc);
        Boolean actual4 = palindrome.isPalindrome("", cc);

        assertTrue(actual1);
        assertTrue(actual3);
        assertFalse(actual2);
        assertTrue(actual4);
    }
}
