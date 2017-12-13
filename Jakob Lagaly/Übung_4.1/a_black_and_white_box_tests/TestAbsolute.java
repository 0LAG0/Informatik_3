/**
 * Created by LAPTOP on 05.12.2017.
 */

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class TestAbsolute {
    public static int absoluteValueOf(int x) {
        if (x < -1)
            return -x;
        else
            return x;
    }

    @Test
    public void testFail() {
        int x = absoluteValueOf(-1);
        assertTrue(x == 1);
    }

    @Test
    public void testSuccess() {
        int x = absoluteValueOf(-2);
        assertTrue(x == 2);
    }
}
