package design;

import java.util.ArrayList;
import java.util.List;

public class DesignHashMap {
	/*
	 * Design a HashMap without using any built-in hash table libraries.
	 *
	 * Implement the MyHashMap class:
	 *
	 * MyHashMap() initializes the object with an empty map. void put(int key,
	 * int value) inserts a (key, value) pair into the HashMap. If the key
	 * already exists in the map, update the corresponding value. int get(int
	 * key) returns the value to which the specified key is mapped, or -1 if
	 * this map contains no mapping for the key. void remove(key) removes the
	 * key and its corresponding value if the map contains the mapping for the
	 * key.
	 *
	 */
	int capacity = 2069;
	List<ArrayList<Data>> list;

	class Data {
		int key;
		int value;

		Data(int k, int v) {
			this.key = k;
			this.value = v;
		}
	}

	/** Initialize your data structure here. */
	public DesignHashMap() {
		list = new ArrayList<>();
		for (int i = 0; i < capacity; i++) {
			list.add(new ArrayList<>());
		}
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		Integer k = key;
		int bucket = k.hashCode() % capacity;
		ArrayList<Data> candidate = list.get(bucket);
		for (Data d : candidate) {
			if (d.key == key) {
				d.value = value;
				return;
			}
		}
		candidate.add(new Data(key, value));
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		Integer k = key;
		int bucket = k.hashCode() % capacity;
		ArrayList<Data> candidate = list.get(bucket);
		for (Data d : candidate) {
			if (d.key == key) {
				return d.value;
			}
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a
	 * mapping for the key
	 */
	public void remove(int key) {
		Integer k = key;
		int bucket = k.hashCode() % capacity;
		ArrayList<Data> candidate = list.get(bucket);
		for (Data d : candidate) {
			if (d.key == key) {
				candidate.remove(d);
				return;
			}
		}
	}
}
