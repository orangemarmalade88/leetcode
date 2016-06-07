package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
		Map<String, Queue<String>> map = new HashMap<>();
		for (String[] ticket : tickets) {
			map.computeIfAbsent(ticket[0], k -> new PriorityQueue<String>())
					.add(ticket[1]);
		}
		Stack<String> stack = new Stack<>();
		stack.push("JFK");
		List<String> result = new LinkedList<>();
		while (!stack.isEmpty()) {
			String peek;
			Queue<String> pq;
			while (map.containsKey(peek = stack.peek())
					&& !(pq = map.get(peek)).isEmpty()) {
				stack.push(pq.poll());
			}
			result.add(0, stack.pop());
		}
		return result;
	}
}
