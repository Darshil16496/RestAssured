package genericUtility;

import java.util.Random;

public class JavaUtility {

	public int getRandomNum() {
		Random r = new Random();
		int random = r.nextInt(500);
		return random;
	}
}
