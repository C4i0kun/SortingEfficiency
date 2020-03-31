package sortingefficiency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberComparatorTest {
	static int a = 1;
	static int b = 2;
	static int c = 0;
	static int d = 1;

	static NumberComparator comp = new NumberComparator();
	
	@Test
	void testCompare1() {
		assertEquals(-1, comp.compare(a, b));
	}
	
	@Test
	void testCompare2() {
		assertEquals(1, comp.compare(a, c));
	}
	
	@Test
	void testeCompare3() {
		assertEquals(0, comp.compare(a, d));
	}

	@Test
	void testEqual1() {
		assertEquals(a == b, comp.equal(a, b));
		assertEquals(a == d, comp.equal(a, d));
	}
	
	@Test
	void testEqual2() {
		assertEquals(a == c, comp.equal(a, c));
	}
	
	@Test
	void testEqual3() {
		assertEquals(a == d, comp.equal(a, d));
	}

	@Test
	void testBiggerThan1() {
		assertEquals(a > b, comp.biggerThan(a, b));

	}
	
	@Test
	void testBiggerThan2() {
		assertEquals(a > c, comp.biggerThan(a, c));
	}
	
	@Test
	void testBiggerThan3() {
		assertEquals(a > d, comp.biggerThan(a, d));
	}

	@Test
	void testSmallerThan1() {
		assertEquals(a < b, comp.smallerThan(a, b));
	}
	
	@Test
	void testSmallerThan2() {
		assertEquals(a < c, comp.smallerThan(a, c));
	}
	
	@Test
	void testSmallerThan3() {
		assertEquals(a < d, comp.smallerThan(a, d));
	}

	@Test
	void testBiggerOrEqualThan1() {
		assertEquals(a >= b, comp.biggerOrEqualThan(a, b));
	}

	@Test
	void testBiggerOrEqualThan2() {
		assertEquals(a >= c, comp.biggerOrEqualThan(a, c));
	}
	
	@Test
	void testBiggerOrEqualThan3() {
		assertEquals(a >= d, comp.biggerOrEqualThan(a, d));
	}
	
	@Test
	void testSmallerOrEqualThan1() {
		assertEquals(a <= b, comp.smallerOrEqualThan(a, b));
	}
	
	@Test
	void testSmallerOrEqualThan2() {
		assertEquals(a <= c, comp.smallerOrEqualThan(a, c));
	}
	
	@Test
	void testSmallerOrEqualThan3() {
		assertEquals(a <= d, comp.smallerOrEqualThan(a, d));
	}

}
