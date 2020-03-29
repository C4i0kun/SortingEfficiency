package sortingefficiency;

/* This BubbleSort algorithm was taken from
 * https://www.geeksforgeeks.org/insertion-sort/
*/

public class InsertionSort extends Sort {
	
	@Override
    public void sortInt(int arr[]) { 
    	int n = arr.length; 
    	
    	for (int i = 1; i < n; ++i) { 
    		int key = arr[i]; 
    		int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
    		while (j >= 0 && arr[j] > key) { 
    			arr[j + 1] = arr[j]; 
    			j = j - 1; 
            } 
    		arr[j + 1] = key; 
        } 
    }

	@Override
	public void sortFloat(float[] arr) {
    	int n = arr.length; 
    	
    	for (int i = 1; i < n; ++i) { 
    		float key = arr[i]; 
    		int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
    		while (j >= 0 && arr[j] > key) { 
    			arr[j + 1] = arr[j]; 
    			j = j - 1; 
            } 
    		arr[j + 1] = key; 
        } 
	}

	@Override
	public void sortDouble(double[] arr) {
    	int n = arr.length; 
    	
    	for (int i = 1; i < n; ++i) { 
    		double key = arr[i]; 
    		int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
    		while (j >= 0 && arr[j] > key) { 
    			arr[j + 1] = arr[j]; 
    			j = j - 1; 
            } 
    		arr[j + 1] = key; 
        } 
		
	}

	@Override
	public void sort(Number[] arr, NumberComparator c) {
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
	}


}
