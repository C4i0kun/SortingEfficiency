package sortingefficiency;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ArraysToSortTest {
	private static ArraysToSort arraysToSort;
	
	@BeforeAll
	static void preparation() {
		arraysToSort = new ArraysToSort(3, 3, 10, 1000000);
	}

	@Test
	void testNumberOfArraysSize() {
		assertEquals(6, arraysToSort.getListOfArrays().size());
	}
	
	@Test
	void testArrayOfNumbers() {
		assertEquals(true, testArrayOfNumbersAux());
	}
	
	private boolean testArrayOfNumbersAux() {
		boolean passed = false;
		
		Iterator<Number[][][]> arrayIterator = arraysToSort.getListOfArrays().iterator();
		while(arrayIterator.hasNext()) {
			Number[][][] currentArray = arrayIterator.next();
			
			for (int i = 0; i < currentArray.length; i++) {
				for (int j = 0; j < currentArray[i].length; j++) {
					for (int k = 0; k < currentArray[i][j].length; k++) {
						passed = currentArray[i][j][k] instanceof Number;
						
						if (passed == false) {
							System.out.println("Failed at [" + i + "][" + j + "][" + k + "]");
							return false;
						}
					}
				}
			}
		}
		
		System.out.println("Every value of the array is a Number!");
		return true;
	}

}
