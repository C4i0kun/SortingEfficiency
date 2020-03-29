package sortingefficiency;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Number[] arr = new Number[10000];
		Random rand = new Random();
		
		for (int i = 0; i < arr.length; i++ ) {
			arr[i] = rand.nextInt(10000);
		}
		
		BubbleSort bubble = new BubbleSort();
		NumberComparator c = new NumberComparator();
		
		bubble.sort(arr, c);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
