package design;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickwithWeight {

	TreeMap<Integer, Integer> map = new TreeMap<>();
	int total = 0;
	Random r = new Random();

	public RandomPickwithWeight(int[] w) {
		int sum = 0;
		for (int i = 0; i < w.length; i++) {
			sum += w[i];
			map.put(sum, i);
		}
		total = sum;
	}

	public int pickIndex() {
		return map.higherEntry(r.nextInt(total)).getValue();
	}
}
