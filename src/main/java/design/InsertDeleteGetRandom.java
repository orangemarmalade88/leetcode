package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {
	List<Integer> list = new ArrayList<>();
	Map<Integer, Integer> map = new HashMap<>();
	Random rand = new Random();

	/** Initialize your data structure here. */
	public InsertDeleteGetRandom() {

	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val))
			return false;
		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;
		int index = map.get(val);
		int new_val = list.get(list.size() - 1);
		list.set(index, new_val);
		list.remove(list.size() - 1);
		map.put(new_val, index);
		map.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int index = rand.nextInt(list.size());
		return list.get(index);
	}
}
