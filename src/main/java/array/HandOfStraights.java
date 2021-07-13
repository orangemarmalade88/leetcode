package array;

import java.util.PriorityQueue;

public class HandOfStraights {
	/*
	 * Alice has a hand of cards, given as an array of integers.
	 * 
	 * Now she wants to rearrange the cards into groups so that each group is
	 * size groupSize, and consists of groupSize consecutive cards.
	 * 
	 * Return true if and only if she can.
	 * 
	 * 
	 */
	public boolean isNStraightHand(int[] hand, int groupSize) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : hand) {
			pq.offer(i);
		}

		while (!pq.isEmpty()) {
			int start = pq.poll();
			for (int i = start + 1; i <= start + groupSize - 1; i++) {
				if (!pq.remove(i)) {
					return false;
				}
			}
		}

		return true;
	}
}
