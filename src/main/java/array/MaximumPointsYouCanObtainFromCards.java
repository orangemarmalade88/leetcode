package array;

public class MaximumPointsYouCanObtainFromCards {
	/*
	 * 1423. Maximum Points You Can Obtain from Cards
	 * 
	 * There are several cards arranged in a row, and each card has an
	 * associated number of points The points are given in the integer array
	 * cardPoints.
	 * 
	 * In one step, you can take one card from the beginning or from the end of
	 * the row. You have to take exactly k cards.
	 * 
	 * Your score is the sum of the points of the cards you have taken.
	 * 
	 * Given the integer array cardPoints and the integer k, return the maximum
	 * score you can obtain.
	 */
	public int maxScore(int[] cardPoints, int k) {
		int sum = 0;
		int l = cardPoints.length;
		for (int i = 0; i < l - k; i++) {
			sum += cardPoints[i];
		}
		int min = sum;
		int total = sum;
		int slow = 0;
		int fast = l - k;
		while (fast < l) {
			sum = sum + cardPoints[fast] - cardPoints[slow];
			min = sum < min ? sum : min;
			total += cardPoints[fast];
			fast++;
			slow++;
		}
		return total - min;
	}
}
