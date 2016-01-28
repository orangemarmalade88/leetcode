package design;

import java.util.HashMap;
import java.util.Map;

/*

 Design and implement a data structure for Least Recently Used (LRU) cache.
 It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present.
 When the cache reached its capacity, it should invalidate the least recently used item
 before inserting a new item.

 */

public class LRUCache {

	// Note1 : Need to store key in the Node because we need to remove the old
	// entry in the map
	// Note2 : Here we are considering writes as "used". Need to clarify
	// Note3 : Need DoublyLinkedList because we need to remove a node by
	// reference in O(1) time

	private class Node {
		Node next;
		Node prev;
		int key;
		int val;

		private Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	private class DoublyLinkedList {
		Node head;
		Node tail;
		int size = 0;

		void appendNode(Node n) {
			Node oldTail = tail;
			n.prev = oldTail;
			tail = n;
			if (oldTail == null)
				head = n;
			else
				oldTail.next = n;
			size++;
		}

		void deleteNode(Node n) {
			if (n == head) {
				head = n.next;
			} else {
				n.prev.next = n.next;
			}
			if (n == tail) {
				tail = n.prev;
			} else {
				n.next.prev = n.prev;
			}
			size--;
		}

		Node removeHead() {
			Node temp = head;
			deleteNode(temp);
			return temp;
		}
	}

	private final Map<Integer, Node> map = new HashMap<>();
	private final DoublyLinkedList dll = new DoublyLinkedList();
	private final int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			dll.deleteNode(old);
			dll.appendNode(old);
			return old.val;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			dll.deleteNode(old);
			dll.appendNode(old);
			old.val = value;
		} else {
			if (dll.size >= capacity) {
				Node evicted = dll.removeHead();
				map.remove(evicted.key);
			}
			Node n = new Node(key, value);
			dll.appendNode(n);
			map.put(key, n);
		}
	}
}
