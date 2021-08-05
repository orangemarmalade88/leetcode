package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomDuplicatesAllowed {
	List<Integer> list = new ArrayList<>();
	Map<Integer, Set<Integer>> map = new HashMap<>();
	Random rand = new Random();

	/** Initialize your data structure here. */
	public InsertDeleteGetRandomDuplicatesAllowed() {

	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		if (!map.containsKey(val)) {
			map.put(val, new HashSet<>());
		}
		list.add(val);
		map.get(val).add(list.size() - 1);
		return map.get(val).size() == 1;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val) || map.get(val).size() == 0)
			return false;
		Set<Integer> ids = map.get(val);
		int index = ids.iterator().next();
		ids.remove(index);

		int size = list.size();
		int new_val = list.get(size - 1);
		list.set(index, new_val);
		list.remove(size - 1);

		map.get(new_val).add(index);
		map.get(new_val).remove(size - 1);

		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		int index = rand.nextInt(list.size());
		return list.get(index);
	}

	public static void main(String[] args) {
		InsertDeleteGetRandomDuplicatesAllowed i = new InsertDeleteGetRandomDuplicatesAllowed();
		i.insert(4);
		i.insert(3);
		i.insert(4);
		i.insert(2);
		i.insert(4);

		i.remove(4);
		i.remove(3);
		i.remove(4);
		i.remove(4);

	}
}
