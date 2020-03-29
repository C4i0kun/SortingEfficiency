package sortingefficiency;

import java.util.ArrayList;
import java.util.Random;

public class Tests {
	public static final int NUMBER_OF_ARRAY_TYPES = 3;
	public static final int NUMBER_OF_SORT_MODES = 3;
	
	public ArrayList<Number[][][]> listOfArrays;

	public Tests() {
		this.listOfArrays = new ArrayList<>();
		
		for (int i = 10; i <= 1000; i *= 10) {
			Number[][][] arr = new Number[NUMBER_OF_ARRAY_TYPES][NUMBER_OF_SORT_MODES][i];
			createArray(arr, i);
			listOfArrays.add(arr);
		}
		
	}
	
	private void createArray(Number[][][] arr, int arraySize) {
		int arrayType = 0;
		
		while (arrayType < NUMBER_OF_ARRAY_TYPES) {
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
	
	private void generateArrayValues(Number[][][] arr, int arrayType, int arraySize) {
		Random rand = new Random();
		NumberComparator c = new NumberComparator();
		
		for (int i = 0; i < arraySize; i++) {
			Number number;
			
			if (arrayType == 0) {
				number = (Number) rand.nextInt(arraySize);
			} else if (arrayType == 1) {
				number = (Number) (arraySize * rand.nextFloat());
			} else {
				number = (Number) (arraySize * rand.nextDouble());
			}
			
			//Random Array
			arr[arrayType][0][i] = number;
			
			//Inverted Array
			if (i == 0) {
				arr[arrayType][1][i] = number;	
			} else {
				for (int j = i; j > 0; j--) {
					if(c.biggerThan(number, arr[arrayType][1][j-1]) ) {
						arr[arrayType][1][j] = arr[arrayType][1][j-1];
						
						if (j == 1) {
							arr[arrayType][1][j-1] = number;
						}
					} else {
						arr[arrayType][1][j] = number;
						break;
					}
				}
			}
			
			//Easy Array
			if (i == 0) {
				arr[arrayType][2][i] = number;	
			} else {
				for (int j = i; j > 0; j--) {
					if(c.smallerThan(number, arr[arrayType][2][j-1]) ) {
						arr[arrayType][2][j] = arr[arrayType][2][j-1];

						if (j == 1) {
							arr[arrayType][1][j-1] = number;
						}
					} else {
						arr[arrayType][2][j] = number;
						break;
					}
				}
			}
		}
	}
	
}
