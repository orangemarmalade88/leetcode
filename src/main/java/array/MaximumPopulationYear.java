package array;

public class MaximumPopulationYear {
	// O(N)
	/*
	 * You are given a 2D integer array logs where each logs[i] = [birthi,
	 * deathi] indicates the birth and death years of the ith person.
	 * 
	 * The population of some year x is the number of people alive during that
	 * year. The ith person is counted in year x's population if x is in the
	 * inclusive range [birthi, deathi - 1]. Note that the person is not counted
	 * in the year that they die.
	 * 
	 * Return the earliest year with the maximum population.
	 * 
	 * 
	 */
	public int maximumPopulation(int[][] logs) {
		int max = 0;
		int max_year = 0;
		for (int y = 1950; y <= 2050; y++) {
			int count = 0;
			for (int[] s : logs) {
				if (y >= s[0] && y < s[1]) {
					count++;
				}
			}
			if (count > max) {
				max = count;
				max_year = y;
			}
		}
		return max_year;
	}
}
