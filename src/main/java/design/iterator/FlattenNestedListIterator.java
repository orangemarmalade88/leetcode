package design.iterator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import model.NestedInteger;

public class FlattenNestedListIterator {
	public class NestedIterator implements Iterator<Integer> {

		Deque<Iterator<NestedInteger>> stack = new ArrayDeque<>();

		public NestedIterator(List<NestedInteger> nestedList) {
			stack.push(nestedList.iterator());
		}

		@Override
		public Integer next() {
			Iterator<NestedInteger> i = stack.peek();
			if (i.hasNext()) {
				NestedInteger next = i.next();
				if (next.isInteger())
					return next.getInteger();
				stack.push(next.getList().iterator());
				return next();
			}
			stack.pop();
			return next();
		}

		@Override
		public boolean hasNext() {
			while (!stack.isEmpty() && !stack.peek().hasNext()) {
				stack.pop();
			}
			return !stack.isEmpty();
		}
	}

	public static void main(String[] args) {
		List<NestedInteger> list = new ArrayList<NestedInteger>();
		List<NestedInteger> list2 = new ArrayList<NestedInteger>();
		NestedInteger n = new NestedInteger(list2);
		list.add(n);
		FlattenNestedListIterator lnli = new FlattenNestedListIterator();
		NestedIterator ni = lnli.new NestedIterator(list);
		while (ni.hasNext()) {
			System.out.println(ni.next());
		}

	}
}
