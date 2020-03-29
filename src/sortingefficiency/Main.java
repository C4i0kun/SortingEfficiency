package sortingefficiency;


public class Main {

	public static void main(String[] args) {
		Tests tests = new Tests();
		for (int i = 0; i < 1000; i++) {
			System.out.println(tests.listOfArrays.get(2)[2][2][i]);
		}
	}

}
