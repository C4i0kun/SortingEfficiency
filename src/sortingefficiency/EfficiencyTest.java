package sortingefficiency;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class EfficiencyTest {
	private String mode;
	
	private ArraysToSort arraysToTest;
	private ArrayList<Sort> sortingAlgorithms = new ArrayList<>();
	
	private ArrayList<Number[][][][]> arraysAfterTest = new ArrayList<>();
	private ArrayList<BigDecimal[][][]> timeResults = new ArrayList<>();
	
	private CSVWriter csvWriter;

	public EfficiencyTest(int numberOfArrayTypes, int numberOfSortModes, int minArraySize, int maxArraySize, String mode) throws IOException {
		this.mode = mode;
		
		this.csvWriter = new CSVWriter();
		this.arraysToTest = new ArraysToSort(numberOfArrayTypes, numberOfSortModes, minArraySize, maxArraySize);
		
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
	
	/* Print index for better readability on terminal */
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
	
	/* Run the sorting alrogithms on every array in arrayForTest*/
	public void run() throws IOException {
		NumberComparator c = new NumberComparator();
		printIndex();
		
		int arraySize = arraysToTest.getMinArraySize();
		
		Iterator<Number[][][]> arrayIterator = arraysToTest.getListOfArrays().iterator();
		while (arrayIterator.hasNext()) {
			Number[][][] arrayToSort = arrayIterator.next();
			
			/*Dimensions explained: Number[number of sort algorithms][number of array types][number of sort modes][size of array] */
			Number[][][][] sortedArrays = new Number[sortingAlgorithms.size()][arraysToTest.getNumberOfArrayTypes()][arraysToTest.getNumberOfSortModes()][arraySize];
			
			/*Dimensions explained: Number[number of sort algorithms][number of array types][number of sort modes] */
			BigDecimal[][][] timeResultsArray = new BigDecimal[sortingAlgorithms.size()][arraysToTest.getNumberOfArrayTypes()][arraysToTest.getNumberOfSortModes()];
					
			System.out.println("Current Array Size: " + arraySize);
			
			for (int i = 0; i < arraysToTest.getNumberOfArrayTypes(); i++) {
				System.out.println("---Current Array Type: " + (i + 1));
				
				for (int j = 0; j < arraysToTest.getNumberOfSortModes(); j++) {
					System.out.println("------Current Sort Mode: " + (j + 1));
					
					int iteratorIndex = 0;
					Iterator<Sort> sortIterator = sortingAlgorithms.iterator();
					while (sortIterator.hasNext()) {
						Number[] clonedArrayToSort = new Number[arrayToSort[i][j].length];
						clonedArrayToSort = arrayToSort[i][j].clone();
						
						timeResultsArray[iteratorIndex][i][j] = sortIterator.next().sort(clonedArrayToSort, c, csvWriter);
						
						sortedArrays[iteratorIndex][i][j] = clonedArrayToSort;
						iteratorIndex++;
					}
				}
				
				csvWriter.writeAll("\n");
			}
			
			csvWriter.writeAll("\n");
			
			timeResults.add(timeResultsArray);
			arraysAfterTest.add(sortedArrays);
			arraySize *= 10;
		}
	}
	
	/* Check if an Array is ordered */
	public static boolean arrayOrdered(Number[] arr, NumberComparator c) {
		for (int i = 1; i < arr.length; i++) {
			if (c.smallerThan(arr[i], arr[i - 1])) {
				return false;
			}
		}
		return true;
	}
	
	/* Getters */
	public ArrayList<Number[][][][]> getResultsOfTest() {
		return arraysAfterTest;
	}

	public ArrayList<BigDecimal[][][]> getTimeResults() {
		return timeResults;
	}

	public String getMode() {
		return mode;
	}
}
