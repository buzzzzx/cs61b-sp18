import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    @Test
    public void testIsSameNumber() {
        int a = 128;
        int b = 128;
        boolean actual = Flik.isSameNumber(a, b);
        assertTrue("Integer a and b are not same numbers.", actual);

        Integer a1 = 129;
        Integer b1 = 129;
        boolean actual1 = Flik.isSameNumber(a1, b1);
        assertTrue("Integer a and b are not same numbers.", actual1);

    }

}
