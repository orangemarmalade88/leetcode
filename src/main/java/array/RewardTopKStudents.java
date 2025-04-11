package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class RewardTopKStudents {
	public List<Integer> topStudents(String[] positive_feedback,
			String[] negative_feedback, String[] report, int[] student_id,
			int k) {
		Set<String> pos = new HashSet<>();
		Set<String> neg = new HashSet<>();
		for (String s : positive_feedback) {
			pos.add(s);
		}
		for (String s : negative_feedback) {
			neg.add(s);
		}
		int size = student_id.length;
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0])
				return Integer.compare(a[0], b[0]);
			return Integer.compare(b[1], a[1]);
		});

		for (int i = 0; i < size; i++) {
			int score = 0;
			String[] words = report[i].split(" ");
			for (String s : words) {
				if (pos.contains(s)) {
					score += 3;
				}
				if (neg.contains(s)) {
					score -= 1;
				}
			}
			pq.offer(new int[] { score, student_id[i] });
			if (pq.size() > k)
				pq.poll();
		}

		List<Integer> result = new ArrayList<>();
		while (!pq.isEmpty())
			result.add(pq.poll()[1]);

		Collections.reverse(result);
		return result;

	}
}
