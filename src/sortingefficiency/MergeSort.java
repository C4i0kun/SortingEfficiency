package sortingefficiency;

import java.math.BigDecimal;

/* This MergeSort algorithm was taken from
 * https://www.geeksforgeeks.org/merge-sort/
*/

public class MergeSort extends Sort {

	@Override
	public void sort(Number[] arr, NumberComparator c) {
		long startTime = System.nanoTime();
		
		mergesort(arr, c, 0, arr.length - 1);
		
		long totalTimeNs = System.nanoTime() - startTime;
		BigDecimal totalTimeSec = (new BigDecimal(totalTimeNs)).divide(new BigDecimal(1000000000));
		System.out.println("---------|MergeSort time (in seconds): " + totalTimeSec);
	}
	
	void merge(Number arr[], NumberComparator c, int l, int m, int r) { 
    	int n1 = m - l + 1; 
    	int n2 = r - m; 
    	
    	Number L[] = new Number [n1]; 
    	Number R[] = new Number [n2]; 

    	for (int i = 0; i < n1; ++i) { 
    		L[i] = arr[l + i];
    	}
    	
    	for (int j = 0; j < n2 ; ++j) { 
            R[j] = arr[m + 1 + j]; 
    	}
    	
    	int i = 0, j = 0; 

    	int k = l; 
    	while (i < n1 && j < n2) { 
    		if (c.smallerOrEqualThan(L[i], R[j])) { 
    			arr[k] = L[i]; 
    			i++; 
    		} else { 
    			arr[k] = R[j]; 
    			j++; 
            }

    		k++; 
    	}
  

    	while (i < n1) { 
    		arr[k] = L[i]; 
    		i++; 
    		k++; 
    	}

    	while (j < n2) { 
    		arr[k] = R[j]; 
    		j++; 
    		k++; 
    	}
    }
	
	void mergesort(Number arr[], NumberComparator c, int l, int r) { 
    	if (l < r) { 
    		int m = (l+r)/2; 
    		 
    		mergesort(arr, c, l, m); 
    		mergesort(arr, c, m+1, r); 
    		 
    		merge(arr, c,  l, m, r); 
        }
    }
    


}
