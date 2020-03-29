package sortingefficiency;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Number[] arr = new Number[10];
		
		for (int i = 0; i < arr.length; i++ ) {
			Random rand = new Random();
			arr[i] = (Number) rand.nextInt(10);
		}
		
		HeapSort heap = new HeapSort();
		NumberComparator c = new NumberComparator();
		
		heap.sort(arr, c);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
