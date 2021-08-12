package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberofOccurrences {

	boolean isUnique(int[] array) {
		if (array.length <= 1)
			return true;
		Arrays.sort(array);
		int slow = 0;
		int fast = 1;
		int count = 1;
		while (fast < array.length) {
			if (array[fast] == array[fast - 1])
				count++;
			else {
				array[slow] = count;
				slow++;
				count = 1;
			}
			fast++;
		}
		array[slow++] = count;
		while (slow < array.length) {
			array[slow++] = -1;
		}

		Arrays.sort(array);
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[i - 1] && array[i] != -1)
				return false;
		}
		return true;
	}

	boolean isUnique2(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> freqs = new HashSet<>();
		for (int i : array) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (int count : map.values()) {
			if (freqs.contains(count))
				return false;
			freqs.add(count);
		}
		return true;
	}

}
