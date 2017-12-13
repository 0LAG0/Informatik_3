package testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AbsoluteValueTest {

	public static int absoluteValueOf(int x) {

		if (x < -1)

			return -x;

		else

			return x;

	}

	@Test
	void test() {
		int x = absoluteValueOf(-1);
		assertEquals(x, -1);

	}

	@Test
	void test1() {
		int x = absoluteValueOf(-1);
		assertEquals(x, 1);

	}
}
