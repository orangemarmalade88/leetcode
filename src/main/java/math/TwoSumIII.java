package math;

import java.util.HashMap;
import java.util.Map;

/*

 Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 For example,

 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false

 */

public class TwoSumIII {

	Map<Integer, Integer> occur_map = new HashMap<>();

	// Add the number to an internal data structure.
	public void add(int number) {
		if (occur_map.containsKey(number)) {
			occur_map.put(number, 2);
		} else {
			occur_map.put(number, 1);
		}
	}

	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		for (Integer key : occur_map.keySet()) {
			if (key + key == value) {
				if (occur_map.get(key) == 2)
					return true;
			} else {
				if (occur_map.containsKey(value - key))
					return true;
			}
		}
		return false;
	}
}
