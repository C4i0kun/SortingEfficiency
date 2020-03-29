package sortingefficiency;

import java.math.BigDecimal;
import java.util.Comparator;

class NumberComparator implements Comparator<Number> {

    public int compare(Number a, Number b){
        return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString()));
    }
    
    public boolean equal(Number a, Number b) {
    	return compare(a,b) == 0;
    }
    
    public boolean biggerThan(Number a, Number b) {
    	return compare(a,b) == 1;
    }

    public boolean SmallerThan(Number a, Number b) {
    	return compare(a,b) == -1;
    }
}
