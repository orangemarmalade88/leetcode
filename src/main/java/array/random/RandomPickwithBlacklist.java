package array.random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomPickwithBlacklist {
	Set<Integer> black = new HashSet<>();
	Map<Integer, Integer> map = new HashMap<>();
	int l;
	Random r = new Random();

	public RandomPickwithBlacklist(int n, int[] blacklist) {
		l = n - blacklist.length;
		for (int i : blacklist) {
			black.add(i);
		}

		int start = n - blacklist.length;
		for (int i : blacklist) {
			if (i < n - blacklist.length) {
				start = findNext(start, black);
				map.put(i, start);
				start++;
			}
		}
	}

	private int findNext(int index, Set<Integer> black) {
		while (black.contains(index)) {
			index++;
		}
		return index;
	}

	public int pick() {
		int num = r.nextInt(l);
		if (black.contains(num))
			return map.get(num);
		return num;
	}
}
