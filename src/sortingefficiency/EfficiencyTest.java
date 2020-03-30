package sortingefficiency;

import java.util.ArrayList;
import java.util.Iterator;

public class EfficiencyTest {
	ArraysToTest arraysToTest;
	ArrayList<Sort> sortingAlgorithms = new ArrayList<>();

	public EfficiencyTest(int numberOfArrayTypes, int numberOfSortModes, int minArraySize, int maxArraySize, String mode) {
		arraysToTest = new ArraysToTest(numberOfArrayTypes, numberOfSortModes, minArraySize, maxArraySize);
		
		if (mode == "n2" || mode == "all") {
			Sort bubbleSort = new BubbleSort();
			Sort insertionSort = new InsertionSort();
			
			sortingAlgorithms.add(bubbleSort);
			sortingAlgorithms.add(insertionSort);
		}

		if (mode == "nlogn" || mode == "all") {
			Sort heapSort = new HeapSort();
			Sort mergeSort = new MergeSort();
			
			sortingAlgorithms.add(heapSort);
			sortingAlgorithms.add(mergeSort);
		}
	}
	
	private void printIndex() {
		System.out.println("ARRAY TYPES INDEX:");
		System.out.println("1 - Array of integers");
		System.out.println("2 - Array of floats");
		System.out.println("3 - Array of doubles");
		
		System.out.println("");
		
		System.out.println("SORT MODES INDEX:");
		System.out.println("1 - Random sort mode");
		System.out.println("2 - Inverted sort mode");
		System.out.println("3 - Easy sort mode");
		
		System.out.println("");
	}
	
	public void run() {
		NumberComparator c = new NumberComparator();
		printIndex();
		
		int arraySize = arraysToTest.getMinArraySize();
		
		Iterator<Number[][][]> arrayIterator = arraysToTest.getListOfArrays().iterator();
		while (arrayIterator.hasNext()) {
			Number[][][] arrayToSort = arrayIterator.next();
			System.out.println("Current Array Size: " + arraySize);
			
			for (int i = 0; i < arraysToTest.getNumberOfArrayTypes(); i++) {
				System.out.println("---Current Array Type: " + (i + 1));
				
				for (int j = 0; j < arraysToTest.getNumberOfSortModes(); j++) {
					System.out.println("------Current Sort Mode: " + (j + 1));
					
					Iterator<Sort> sortIterator = sortingAlgorithms.iterator();
					while (sortIterator.hasNext()) {
						Number[] clonedArrayToSort = new Number[arrayToSort[i][j].length];
						clonedArrayToSort = arrayToSort[i][j].clone();
						sortIterator.next().sort(clonedArrayToSort ,c);
					}
				}
			}
			
			arraySize *= 10;
		}
	}
	
	public static boolean arrayOrdered(Number[] arr, NumberComparator c) {
		for (int i = 1; i < arr.length; i++) {
			if (c.smallerThan(arr[i], arr[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
