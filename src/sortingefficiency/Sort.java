package sortingefficiency;

import java.io.IOException;
import java.math.BigDecimal;

public abstract class Sort {
	public abstract BigDecimal sort(Number[] arr, NumberComparator c, CSVWriter csvWriter) throws IOException;
}
