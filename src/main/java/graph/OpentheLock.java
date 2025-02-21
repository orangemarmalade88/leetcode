package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpentheLock {

	List<String> getNext(String current) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			char c = current.charAt(i);

			StringBuilder sb_1 = new StringBuilder(current);
			if (c == '9')
				sb_1.setCharAt(i, '0');
			else
				sb_1.setCharAt(i, (char) (c + 1));
			res.add(sb_1.toString());

			StringBuilder sb_2 = new StringBuilder(current);
			if (c == '0')
				sb_2.setCharAt(i, '9');
			else
				sb_2.setCharAt(i, (char) (c - 1));
			res.add(sb_2.toString());
		}
		return res;
	}

	public int openLock(String[] deadends, String target) {
		Set<String> deads = new HashSet<>();
		for (String s : deadends) {
			deads.add(s);
		}

		String init = "0000";

		if (deads.contains(init))
			return -1;

		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(init);
		visited.add(init);

		int steps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String current = queue.poll();

				if (current.equals(target))
					return steps;
				List<String> nexts = getNext(current);
				for (String next : nexts) {
					if (!visited.contains(next) && !deads.contains(next)) {
						queue.offer(next);
						visited.add(next);
					}
				}
			}
			steps++;
		}
		return -1;
	}
}
