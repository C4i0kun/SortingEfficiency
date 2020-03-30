package sortingefficiency;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortTest {
	static Number[] arr1 = new Number[10000];
	static Number[] arr2 = new Number[10000];
	static Number[] arr3 = new Number[10000];
	
	static BubbleSort bubbleSort = new BubbleSort();
	static InsertionSort insertionSort = new InsertionSort();
	static HeapSort heapSort = new HeapSort();
	static MergeSort mergeSort = new MergeSort();
	
	static NumberComparator c = new NumberComparator();
	
	@BeforeEach
	void preparation() {
		Random rand = new Random();
		
		for (int i = 0; i < 10000; i++) {
			arr1[i] = (Number) rand.nextInt(10000);
			arr2[i] = (Number) (10000 * rand.nextFloat());
			arr3[i] = (Number) (10000 * rand.nextDouble());
		}
	}

	@Test
	void testBubbleSortInt() {
		bubbleSort.sort(arr1, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr1, c));
	}
	
	@Test
	void testBubbleSortFloat() {
		bubbleSort.sort(arr2, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr2, c));
	}

	@Test
	void testBubbleSortDouble() {
		bubbleSort.sort(arr3, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr3, c));
	}

	@Test
	void testInsertionSortInt() {
		insertionSort.sort(arr1, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr1, c));
	}
	
	@Test
	void testInsertionSortFloat() {
		insertionSort.sort(arr2, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr2, c));
	}
	
	@Test
	void testInsertionSortDouble() {
		insertionSort.sort(arr3, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr3, c));
	}

	@Test
	void testHeapSortInt() {
		heapSort.sort(arr1, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr1, c));
	}

	@Test
	void testHeapSortFloat() {
		heapSort.sort(arr2, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr2, c));
	}
	
	@Test
	void testHeapSortDouble() {
		heapSort.sort(arr3, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr3, c));
	}
	
	@Test
	void testeMergeSortInt() {
		mergeSort.sort(arr1, c);		
		assertEquals(true, EfficiencyTest.arrayOrdered(arr1, c));
	}

	@Test
	void testeMergeSortFloat() {
		mergeSort.sort(arr2, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr2, c));
	}
	
	@Test
	void testeMergeSortDouble() {
		mergeSort.sort(arr3, c);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr3, c));
	}

}
