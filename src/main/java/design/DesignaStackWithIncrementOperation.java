package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DesignaStackWithIncrementOperation {

	public class CustomStack {

		List<Integer> list;
		int max = 0;
		int size = 0;

		public CustomStack(int maxSize) {
			max = maxSize;
			list = new ArrayList<>();

		}

		public void push(int x) {
			if (size < max) {
				if (list.size() == size) {
					list.add(x);
					size++;
				} else {
					list.set(size, x);
					size++;
				}
			}
		}

		public int pop() {
			if (size == 0)
				return -1;
			int val = list.get(size - 1);
			size--;
			return val;
		}

		public void increment(int k, int val) {
			for (int i = 0; i < k && i < size; i++) {
				list.set(i, list.get(i) + val);
			}
		}
	}

	int n;
	int[] inc;
	Stack<Integer> stack;

	public DesignaStackWithIncrementOperation(int maxSize) {
		n = maxSize;
		inc = new int[n];
		stack = new Stack<>();
	}

	public void push(int x) {
		if (stack.size() < n)
			stack.push(x);
	}

	public int pop() {
		int i = stack.size() - 1;
		if (i < 0)
			return -1;
		if (i > 0)
			inc[i - 1] += inc[i];
		int res = stack.pop() + inc[i];
		inc[i] = 0;
		return res;
	}

	public void increment(int k, int val) {
		int i = Math.min(k, stack.size()) - 1;
		if (i >= 0)
			inc[i] += val;
	}

	public static void main(String[] args) {
		DesignaStackWithIncrementOperation d = new DesignaStackWithIncrementOperation(
				3);
		d.push(1);
		d.push(2);
		d.push(3);
		d.push(4);
		d.increment(5, 100);
		d.increment(2, 100);
		d.pop();
		d.pop();
		d.pop();
	}
}
