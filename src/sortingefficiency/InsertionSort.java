package sortingefficiency;

import java.math.BigDecimal;

/* This InsertionSort algorithm was taken from
 * https://www.geeksforgeeks.org/insertion-sort/
*/

public class InsertionSort extends Sort {

	@Override
	public void sort(Number[] arr, NumberComparator c) {
		long startTime = System.nanoTime();
	
    	int n = arr.length; 
    	
    	for (int i = 1; i < n; ++i) { 
    		Number key = arr[i]; 
    		int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
    		while (j >= 0 && c.biggerThan(arr[j], key)) { 
    			arr[j + 1] = arr[j]; 
    			j = j - 1; 
            } 
    		arr[j + 1] = key; 
        } 
    	
    	long totalTimeNs = System.nanoTime() - startTime;
		BigDecimal totalTimeSec = (new BigDecimal(totalTimeNs)).divide(new BigDecimal(1000000000));
		System.out.println("---------|InsertionSort time (in seconds): " + totalTimeSec);
	}


}
