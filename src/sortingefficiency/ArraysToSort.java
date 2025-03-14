package sortingefficiency;

import java.util.ArrayList;
import java.util.Random;

public class ArraysToSort {
	private int numberOfArrayTypes;
	private int numberOfSortModes;
	private int minArraySize;
	private int maxArraySize;
	
	/*Dimensions explained: Number[number of array types][number of sort modes][size of array] */
	private ArrayList<Number[][][]> listOfArrays;

	public ArraysToSort(int numberOfArrayTypes, int numberOfSortModes, int minArraySize, int maxArraySize) {
		this.numberOfArrayTypes = numberOfArrayTypes;
		this.numberOfSortModes = numberOfSortModes;
		this.minArraySize = minArraySize;
		this.maxArraySize = maxArraySize;
		
		this.listOfArrays = new ArrayList<>();
		
		for (int i = minArraySize; i <= maxArraySize; i *= 10) {
			Number[][][] arr = new Number[numberOfArrayTypes][numberOfSortModes][i];
			createArray(arr, i);
			listOfArrays.add(arr);
		}
		
		System.out.println("Arrays generated!");
		System.out.println("");
	}
	
	/*  Create the multidimensional array with all arrays that will be sorted */
	private void createArray(Number[][][] arr, int arraySize) {
		int arrayType = 0;
		
		while (arrayType < numberOfArrayTypes) {
			if (arrayType == 0) {
				generateArrayValues(arr, arrayType, arraySize);
			} else if (arrayType == 1) {
				generateArrayValues(arr, arrayType, arraySize);
			} else {
				generateArrayValues(arr, arrayType, arraySize);
			}

			arrayType++;
		}
	}
	
	/* Automatically generate values to the unsorted arrays considering the sortMode */
	private void generateArrayValues(Number[][][] arr, int arrayType, int arraySize) {
		Random rand = new Random();
		
		for (int i = 0; i < arraySize; i++) {
			Number[] number = new Number[3];
			
			if (arrayType == 0) {
				number[0] = (Number) rand.nextInt(arraySize);
				number[1] = (Number) (arraySize - (i + 1));
				number[2] = (Number) i;
			} else if (arrayType == 1) {
				number[0] = (Number) (arraySize * rand.nextFloat());
				number[1] = (Number) ((arraySize - (i + 1)) + rand.nextFloat());
				number[2] = (Number) (i + rand.nextFloat());
				
			} else {
				number[0] = (Number) (arraySize * rand.nextDouble());
				number[1] = (Number) ((arraySize - (i + 1)) + rand.nextDouble());
				number[2] = (Number) (i + rand.nextDouble());
			}
			
			//Random Array
			arr[arrayType][0][i] = number[0];
			
			//Inverted Array
			arr[arrayType][1][i] = number[1];
			
			//Easy Array (Almost sorted)
			if (rand.nextInt(10) == 0) {
				arr[arrayType][2][i] = number[0];
			} else {
				arr[arrayType][2][i] = number[2];
			}
		}
	}

	/* Getters */
	public int getMaxArraySize() {
		return maxArraySize;
	}

	public int getNumberOfSortModes() {
		return numberOfSortModes;
	}

	public int getMinArraySize() {
		return minArraySize;
	}	

	public int getNumberOfArrayTypes() {
		return numberOfArrayTypes;
	}

	public ArrayList<Number[][][]> getListOfArrays() {
		return listOfArrays;
	}
}
