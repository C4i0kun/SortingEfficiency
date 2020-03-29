package sortingefficiency;

import java.util.ArrayList;
import java.util.Random;

public class Arrays {
	public static final int NUMBER_OF_ARRAY_TYPES = 3;
	public static final int NUMBER_OF_SORT_MODES = 3;
	public static final int MAX_ARRAY_SIZE = 1000000;
	
	public ArrayList<Number[][][]> listOfArrays;

	public Arrays() {
		this.listOfArrays = new ArrayList<>();
		
		for (int i = 10; i <= MAX_ARRAY_SIZE; i *= 10) {
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
			//Easy Array
			if (rand.nextInt(10)==0) {
				arr[arrayType][2][i] = number[0];
			} else {
				arr[arrayType][2][i] = number[2];
			}
		}
	}
	
}
