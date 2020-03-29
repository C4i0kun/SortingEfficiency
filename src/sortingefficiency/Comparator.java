package sortingefficiency;

public class Comparator {
	public static <T extends Number & Comparable<T>> int compare(T a, T b) {
		return a.compareTo(b);
	}
	
	public static <T extends Number & Comparable<T>> boolean biggerThan(T a, T b) {
		return a.compareTo(b) == 1;
	}
	
	public static <T extends Number & Comparable<T>> boolean equalTo(T a, T b) {
		return a.compareTo(b) == 0;
	}
	
	public static <T extends Number & Comparable<T>> boolean smallerThan(T a, T b) {
		return a.compareTo(b) == -1;
	}
}
