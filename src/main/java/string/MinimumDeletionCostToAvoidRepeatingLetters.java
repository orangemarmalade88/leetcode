package string;

public class MinimumDeletionCostToAvoidRepeatingLetters {

	/*
	 * Given a string s and an array of integers cost where cost[i] is the cost
	 * of deleting the ith character in s.
	 *
	 * Return the minimum cost of deletions such that there are no two identical
	 * letters next to each other.
	 *
	 * Notice that you will delete the chosen characters at the same time, in
	 * other words, after deleting a character, the costs of deleting other
	 * characters will not change.
	 *
	 *
	 */
	public int minCost(String s, int[] cost) {
		int sum = 0;
		for (int i = 0; i < cost.length; i++) {
			int total = 0;
			int max = 0;
			if (i + 1 < cost.length && s.charAt(i) == s.charAt(i + 1)) {
				total = cost[i];
				max = cost[i];
				while (i + 1 < cost.length && s.charAt(i) == s.charAt(i + 1)) {
					i++;
					total += cost[i];
					max = Math.max(max, cost[i]);
				}

				sum += (total - max);
			}

		}
		return sum;
	}
}
