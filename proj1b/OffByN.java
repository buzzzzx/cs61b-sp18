public class OffByN implements CharacterComparator {

    private int N;
    public OffByN(int N) {
        this.N = N;
    }

    /**
     * Returns true if characters are equal by the rules of the implementing class.
     */
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return Math.abs(diff) == N;
    }
}
