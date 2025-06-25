package array.random;

import java.util.Random;

public class ShuffleAnArray {

	int[] copy;
	Random r = new Random();

	public ShuffleAnArray(int[] nums) {
		copy = nums.clone();
	}

	public int[] reset() {
		return copy;
	}

	public int[] shuffle() {
		int[] shuffled = copy.clone();
		for (int i = 0; i < copy.length; i++) {
			int index = i + r.nextInt(copy.length - i);
			int temp = shuffled[i];
			shuffled[i] = shuffled[index];
			shuffled[index] = temp;
		}

		return shuffled;
	}
}
