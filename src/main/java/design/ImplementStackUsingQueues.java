package design;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	// New idea: make sure the queue itself is always a stack!
	Queue<Integer> q = new LinkedList<>();

	// Push element x onto stack.
	public void push(int x) {
		q.offer(x);
		for (int i = 0; i < q.size() - 1; i++) {
			q.offer(q.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		q.poll();
	}

	// Get the top element.
	public int top() {
		return q.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q.isEmpty();
	}

	public class OtherSolutions {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		Queue<Integer> current = q1;
		Queue<Integer> next = q2;

		// Push element x onto stack.
		public void push(int x) {
			current.add(x);
		}

		// Removes the element on top of the stack.
		public void pop() {
			while (current.size() > 1) {
				next.add(current.poll());
			}
			current.poll();
			switchQueues();
		}

		// Get the top element.
		public int top() {
			while (current.size() > 1) {
				next.add(current.poll());
			}
			return current.peek();
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return current.isEmpty() && next.isEmpty();
		}

		private void switchQueues() {
			Queue<Integer> temp = current;
			current = next;
			next = temp;
		}

		// Idea: current is a stack, q2 is temporary storage
		public class ImplementStackUsingQueues2 {
			Queue<Integer> q1 = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			Queue<Integer> current = q1;
			Queue<Integer> next = q2;

			// Push element x onto stack.
			public void push(int x) {
				next.offer(x);
				while (!current.isEmpty()) {
					next.offer(current.poll());
				}
				switchQueues();
			}

			// Removes the element on top of the stack.
			public void pop() {
				current.poll();
			}

			// Get the top element.
			public int top() {
				return current.peek();
			}

			// Return whether the stack is empty.
			public boolean empty() {
				return current.isEmpty() && next.isEmpty();
			}

			private void switchQueues() {
				Queue<Integer> temp = current;
				current = next;
				next = temp;
			}
		}
	}
}
