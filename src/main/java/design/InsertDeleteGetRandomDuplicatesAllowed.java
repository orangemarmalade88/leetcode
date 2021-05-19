package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomDuplicatesAllowed {
	/*
	 * Implement the RandomizedCollection class:
	 * 
	 * RandomizedCollection() Initializes the RandomizedCollection object. bool
	 * insert(int val) Inserts an item val into the multiset if not present.
	 * Returns true if the item was not present, false otherwise. bool
	 * remove(int val) Removes an item val from the multiset if present. Returns
	 * true if the item was present, false otherwise. Note that if val has
	 * multiple occurrences in the multiset, we only remove one of them. int
	 * getRandom() Returns a random element from the current multiset of
	 * elements (it's guaranteed that at least one element exists when this
	 * method is called). The probability of each element being returned is
	 * linearly related to the number of same values the multiset contains.
	 * 
	 */
	// Mistakes made: when last val is val, two sets are same.
	// need to first remove then add. otherwise we remove 2 index from set.

	List<Integer> list;
	Map<Integer, Set<Integer>> map;
	int size;
	Random r;

	/** Initialize your data structure here. */
	public InsertDeleteGetRandomDuplicatesAllowed() {
		list = new ArrayList<>();
		map = new HashMap<>();
		size = 0;
		r = new Random();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean ans = false;
		list.add(val);
		if (!map.containsKey(val)) {
			map.put(val, new HashSet<>());
			ans = true;
		}
		map.get(val).add(size);
		size++;
		return ans;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val) || map.get(val).isEmpty()) {
			return false;
		}
		// get last element and index
		int last = list.get(size - 1);

		// get val's index
		Set<Integer> val_set = map.get(val);
		int index = val_set.iterator().next();

		// swap last and current in array
		list.set(index, last);
		list.remove(size - 1);

		// fix index in sets
		Set<Integer> last_set = map.get(last);

		// ORDER MATTERS HERE!
		val_set.remove(index);
		last_set.add(index);
		last_set.remove(size - 1);

		size--;
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return list.get(r.nextInt(size));
	}

	public static void main(String[] args) {
		InsertDeleteGetRandomDuplicatesAllowed i = new InsertDeleteGetRandomDuplicatesAllowed();
		i.insert(0);
		i.remove(0);
		i.insert(-1);
		i.remove(0);
		i.getRandom();
	}
}
