import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {
    @Test
    public void randomTest() {
        StudentArrayDeque<Integer> t = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> s = new ArrayDequeSolution<>();

        for (int i = 0; i < 30; i += 1) {
            int f = StdRandom.uniform(3);
            int addNum;
            switch (f) {
                case 0:
                    addNum = StdRandom.uniform(10);
                    t.addFirst(addNum);
                    s.addFirst(addNum);
                    break;

                case 1:
                    addNum = StdRandom.uniform(10);
                    t.addLast(addNum);
                    s.addLast(addNum);
                    break;

                case 2:
                    if (!t.isEmpty()) {
                        int tRamdom = t.removeFirst();
                        int sRamdom = s.removeFirst();
                        assertEquals("removeFirst()", tRamdom, sRamdom);
                    }
                    break;

                case 3:
                    if (!s.isEmpty()) {
                        int tRamdom = t.removeLast();
                        int sRamdom = s.removeLast();
                        assertEquals("removeLast()", tRamdom, sRamdom);
                    }
                    break;

                default:
                    break;
            }

        }
        for (int i = 0; i < s.size(); i += 1) {
            assertEquals(s.get(i), t.get(i));
        }
    }
}
