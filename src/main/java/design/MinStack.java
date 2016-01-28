package design;

import java.util.Stack;

/*

 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 */

public class MinStack {

	// Other thoughts: push a current min for each element (2 N space)

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> min_stack = new Stack<>();

	public void push(int x) {
		stack.push(x);
		// Mistake: Missing equal sign here
		if (min_stack.isEmpty() || x <= min_stack.peek())
			min_stack.push(x);
	}

	public void pop() {
		int x = stack.pop();
		if (min_stack.peek() == x)
			min_stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min_stack.peek();
	}
}
