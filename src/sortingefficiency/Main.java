package sortingefficiency;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		EfficiencyTest test = new EfficiencyTest(3, 3, 10, 1000, "all");
		test.run();
	}

}
