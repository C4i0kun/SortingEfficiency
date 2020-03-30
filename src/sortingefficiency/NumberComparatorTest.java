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
	void testCompare() {
		assertEquals(-1, comp.compare(a, b));
		assertEquals(1, comp.compare(a, c));
		assertEquals(0, comp.compare(a, d));
	}

	@Test
	void testEqual() {
		assertEquals(a == b, comp.equal(a, b));
		assertEquals(a == c, comp.equal(a, c));
		assertEquals(a == d, comp.equal(a, d));
	}

	@Test
	void testBiggerThan() {
		assertEquals(a > b, comp.biggerThan(a, b));
		assertEquals(a > c, comp.biggerThan(a, c));
		assertEquals(a > d, comp.biggerThan(a, d));
	}

	@Test
	void testSmallerThan() {
		assertEquals(a < b, comp.smallerThan(a, b));
		assertEquals(a < c, comp.smallerThan(a, c));
		assertEquals(a < d, comp.smallerThan(a, d));
	}

	@Test
	void testBiggerOrEqualThan() {
		assertEquals(a >= b, comp.biggerOrEqualThan(a, b));
		assertEquals(a >= c, comp.biggerOrEqualThan(a, c));
		assertEquals(a >= d, comp.biggerOrEqualThan(a, d));
	}

	@Test
	void testSmallerOrEqualThan() {
		assertEquals(a <= b, comp.smallerOrEqualThan(a, b));
		assertEquals(a <= c, comp.smallerOrEqualThan(a, c));
		assertEquals(a <= d, comp.smallerOrEqualThan(a, d));
	}

}
