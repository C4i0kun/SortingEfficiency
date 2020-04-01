package sortingefficiency;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
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
	static CSVWriter csvWriter;
	
	@BeforeEach
	void preparation() throws IOException {
		csvWriter = new CSVWriter();
		
		Random rand = new Random();
		
		for (int i = 0; i < 10000; i++) {
			arr1[i] = (Number) rand.nextInt(10000);
			arr2[i] = (Number) (10000 * rand.nextFloat());
			arr3[i] = (Number) (10000 * rand.nextDouble());
		}
	}

	@Test
	void testBubbleSortInt() throws IOException {
		bubbleSort.sort(arr1, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr1, c));
	}
	
	@Test
	void testBubbleSortFloat() throws IOException {
		bubbleSort.sort(arr2, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr2, c));
	}

	@Test
	void testBubbleSortDouble() throws IOException {
		bubbleSort.sort(arr3, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr3, c));
	}

	@Test
	void testInsertionSortInt() throws IOException {
		insertionSort.sort(arr1, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr1, c));
	}
	
	@Test
	void testInsertionSortFloat() throws IOException {
		insertionSort.sort(arr2, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr2, c));
	}
	
	@Test
	void testInsertionSortDouble() throws IOException {
		insertionSort.sort(arr3, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr3, c));
	}

	@Test
	void testHeapSortInt() throws IOException {
		heapSort.sort(arr1, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr1, c));
	}

	@Test
	void testHeapSortFloat() throws IOException {
		heapSort.sort(arr2, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr2, c));
	}
	
	@Test
	void testHeapSortDouble() throws IOException {
		heapSort.sort(arr3, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr3, c));
	}
	
	@Test
	void testeMergeSortInt() throws IOException {
		mergeSort.sort(arr1, c, csvWriter);		
		assertEquals(true, EfficiencyTest.arrayOrdered(arr1, c));
	}

	@Test
	void testeMergeSortFloat() throws IOException {
		mergeSort.sort(arr2, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr2, c));
	}
	
	@Test
	void testeMergeSortDouble() throws IOException {
		mergeSort.sort(arr3, c, csvWriter);
		assertEquals(true, EfficiencyTest.arrayOrdered(arr3, c));
	}

}
