package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {
	/*
	 * Implement the RandomizedSet class:
	 * 
	 * RandomizedSet() Initializes the RandomizedSet object. bool insert(int
	 * val) Inserts an item val into the set if not present. Returns true if the
	 * item was not present, false otherwise. bool remove(int val) Removes an
	 * item val from the set if present. Returns true if the item was present,
	 * false otherwise. int getRandom() Returns a random element from the
	 * current set of elements (it's guaranteed that at least one element exists
	 * when this method is called). Each element must have the same probability
	 * of being returned.
	 * 
	 */
	private final Map<Integer, Integer> map;
	private final ArrayList<Integer> list;
	private int size;
	private final Random rand = new Random();

	/** Initialize your data structure here. */
	public InsertDeleteGetRandom() {
		map = new HashMap<>();
		list = new ArrayList<>();
		size = 0;
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		} else {
			list.add(val);
			map.put(val, size);
			size++;
			return true;
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		} else {
			Integer index = map.get(val);
			int last = list.get(size - 1);
			list.set(index, last);
			map.put(last, index);

			list.remove(size - 1);
			map.remove(val);
			size--;
			return true;
		}
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int index = rand.nextInt(size);
		return list.get(index);
	}
}
