package sortingefficiency;

import java.math.BigDecimal;

/* This BubbleSort algorithm was taken from
 * https://www.javatpoint.com/bubble-sort-in-java 
*/

public class BubbleSort extends Sort{

	@Override
	public void sort(Number[] arr, NumberComparator c) {
		long startTime = System.currentTimeMillis();
		
		int n = arr.length;
		Number temp = 0;
		
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(c.biggerThan(arr[j-1], arr[j])){  
					//swap elements  
					temp = arr[j-1];  
					arr[j-1] = arr[j];  
					arr[j] = temp;  
				}         
			}
		}
		
		long totalTimeMs = System.currentTimeMillis() - startTime;
		BigDecimal totalTimeSec = (new BigDecimal(totalTimeMs)).divide(new BigDecimal(1000));
		System.out.println("---------BubbleSort time (in seconds): " + totalTimeSec + " " + EfficiencyTest.arrayOrdered(arr, c));
	}
}