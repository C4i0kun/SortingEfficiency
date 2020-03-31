package sortingefficiency;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EfficiencyTestTest {
	static Number[] arr1 = {1, 3, 4, 5, 6, 7, 8, 9, 12, 14};
	static Number[] arr2 = {1, 4, 5, 6, 12, 7, 8, 9, 3, 14};
	static Number[] arr3 = {3, 5, 7, 9, 10, 18, 21, 44, 57};
	static Number[] arr4 = {9, 5, 18, 92, 10, 13, 14, 44, 57};
	static Number[] arr5 = {2.0, 3.45, 9.443, 10.554, 15.989, 16.166, 24.998, 42.887, 42.889, 42.998};
	static Number[] arr6 = {2.0, 3.45, 9.443, 10.554, 15.989, 16.166, 24.998, 42.998, 42.889, 42.998};
	static NumberComparator c = new NumberComparator();
	static EfficiencyTest test;;
	
	@BeforeAll
	static void preparation() {
		test = new EfficiencyTest(3, 3, 1000, 1000, "all");
		test.run();
	}
	
	/* This function tests if, after a run, the arrays are sorted!*/
	@Test
	void testRunSorting() {
		/* All result arrays must be sorted! */
		assertEquals(true, testRunAux(test, "Sorting"));
		
	}
	
	@Test
	void testRunResults() {
		/* All result arrays must be sorted! */
		assertEquals(true, testRunAux(test, "Results"));
		
	}
	
	private boolean testRunAux(EfficiencyTest test, String mode) {
		if (mode == "Sorting") {
			Iterator<Number[][][][]> resultsIterator = test.getResultsOfTest().iterator();		
			while(resultsIterator.hasNext()) {
				Number[][][][] currentArray = resultsIterator.next();
				for (int i = 0; i < currentArray.length; i++) {
					for (int j = 0; j < currentArray[i].length; j++) {
						for (int k = 0; k < currentArray[i][j].length; k++) {
							if (EfficiencyTest.arrayOrdered(currentArray[i][j][k], c) == false) {
								System.out.println("Failed: Array [" + i + "][" + j + "][" + k + "] is unsorted!");
								return false;
							}
						}
					}
				}
			}
			
			System.out.println("All arrays are sorted!");
			return true;
			
		} else if (mode == "Results") {
			Iterator<BigDecimal[][][]> resultsIterator = test.getTimeResults().iterator();		
			while(resultsIterator.hasNext()) {
				BigDecimal[][][] currentArray = resultsIterator.next();
				for (int i = 0; i < currentArray.length; i++) {
					for (int j = 0; j < currentArray[i].length; j++) {
						for (int k = 0; k < currentArray[i][j].length; k++) {
							if (currentArray[i][j][k] instanceof BigDecimal) {
								System.out.println("Failed: element [" + i + "][" + j + "][" + k + "] is not a BigDecimal!");
								return false;
							}
						}
					}
				}
			}
			
			System.out.println("All results are BigDecimals!");
			return true;
		} else {
			return true;
		}
	}
	
	@Test
	void testArrayOrdered_1() {
		assertEquals(true, EfficiencyTest.arrayOrdered(arr1, c));
	}
	
	@Test
	void testArrayOrdered_2() {
		assertEquals(false, EfficiencyTest.arrayOrdered(arr2, c));
	}

	@Test
	void testArrayOrdered_3() {
		assertEquals(true, EfficiencyTest.arrayOrdered(arr3, c));
	}

	@Test
	void testArrayOrdered_4() {
		assertEquals(false, EfficiencyTest.arrayOrdered(arr4, c));
	}
	
	@Test
	void testArrayOrdered_5() {
		assertEquals(true, EfficiencyTest.arrayOrdered(arr5, c));
	}
	
	@Test
	void testArrayOrdered_6() {
		assertEquals(false, EfficiencyTest.arrayOrdered(arr6, c));
	}

}
