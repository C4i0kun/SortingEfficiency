package sortingefficiency;

import java.io.IOException;
import java.math.BigDecimal;

/* This HeapSort algorithm was taken from
 * https://www.geeksforgeeks.org/java-program-for-heap-sort/
*/

public class HeapSort extends Sort {

	@Override
	public BigDecimal sort(Number[] arr, NumberComparator c, CSVWriter csvWriter) throws IOException {
		long startTime = System.nanoTime();
		
		int n = arr.length; 
		
		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, c, n, i); 
		}
  
		// One by one extract an element from heap 
		for (int i = n - 1; i >= 0; i--) { 
			// Move current root to end 
			Number temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp; 

			heapify(arr, c, i, 0); 
        }

		long totalTimeNs = System.nanoTime() - startTime;
		BigDecimal totalTimeSec = (new BigDecimal(totalTimeNs)).divide(new BigDecimal(1000000000));
		System.out.println("---------|HeapSort time (in seconds): " + totalTimeSec);
		csvWriter.write(totalTimeSec.toString() + ",","HeapFile");
		return totalTimeSec;
	}
	
	void heapify(Number arr[], NumberComparator c, int n, int i) { 
		int largest = i;  // Initialize largest as root 
		int l = 2*i + 1;  // left = 2*i + 1 
		int r = 2*i + 2;  // right = 2*i + 2 

		// If left child is larger than root 
		if (l < n && c.biggerThan(arr[l], arr[largest])) {
			largest = l; 
		}
		// If right child is larger than largest so far 
		if (r < n && c.biggerThan(arr[r], arr[largest])) {
			largest = r; 
		}
		// If largest is not root 
		if (largest != i) { 
			Number swap = arr[i]; 
			arr[i] = arr[largest]; 
			arr[largest] = swap; 

			// Recursively heapify the affected sub-tree 
			heapify(arr, c, n, largest); 
		}
	}
}
