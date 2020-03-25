public class Palindrome {

    /**
     * Returns a deque with items which are characters of the given word.
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> D = new ArrayDeque<>();
        int i;
        for (i = 0; i < word.length(); i += 1) {
            char c = word.charAt(i);
            D.addLast(c);
        }
        return D;
    }

    /**
     * Helper method that return true if word is palindrome.
     */
    private boolean isPalindromeHelper(Deque<Character> D) {
        if (D.isEmpty() || (D.size() == 1)) {
            return true;
        }
        char last = D.removeLast();
        char first = D.removeFirst();
        return (last == first) && isPalindromeHelper(D);
    }

    /**
     * Returns true if word is palindrome, false otherwise.
     */
    public boolean isPalindrome(String word) {
        Deque<Character> D = wordToDeque(word);
        return isPalindromeHelper(D);
    }

    /**
     * Helper method that return true if word is palindrome according to the character comparison.
     */
    private boolean isPalindromeWithComparatorHelper(Deque<Character> D, CharacterComparator cc) {
        if (D.isEmpty() || (D.size() == 1)) {
            return true;
        }
        char last = D.removeLast();
        char first = D.removeFirst();
        return (cc.equalChars(last, first)) && isPalindromeWithComparatorHelper(D, cc);
    }
    /**
     * Returns true if the word is a palindrome according to the character comparison.
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> D = wordToDeque(word);
        return isPalindromeWithComparatorHelper(D, cc);
    }
}
