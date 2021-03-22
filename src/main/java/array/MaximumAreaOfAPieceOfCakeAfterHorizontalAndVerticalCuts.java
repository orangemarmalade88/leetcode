package array;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
	/*
	 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
	 *
	 * Given a rectangular cake with height h and width w, and two arrays of
	 * integers horizontalCuts and verticalCuts where horizontalCuts[i] is the
	 * distance from the top of the rectangular cake to the ith horizontal cut
	 * and similarly, verticalCuts[j] is the distance from the left of the
	 * rectangular cake to the jth vertical cut.
	 *
	 * Return the maximum area of a piece of cake after you cut at each
	 * horizontal and vertical position provided in the arrays horizontalCuts
	 * and verticalCuts. Since the answer can be a huge number, return this
	 * modulo 10^9 + 7.
	 */
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		int horizontal_max = horizontalCuts[0];
		for (int i = 1; i < horizontalCuts.length; i++) {
			int dist = horizontalCuts[i] - horizontalCuts[i - 1];
			horizontal_max = Math.max(horizontal_max, dist);
		}
		horizontal_max = Math.max(horizontal_max,
				h - horizontalCuts[horizontalCuts.length - 1]);

		Arrays.sort(verticalCuts);
		int vertical_max = verticalCuts[0];
		for (int i = 1; i < verticalCuts.length; i++) {
			int dist = verticalCuts[i] - verticalCuts[i - 1];
			vertical_max = Math.max(vertical_max, dist);
		}
		vertical_max = Math.max(vertical_max,
				w - verticalCuts[verticalCuts.length - 1]);

		return (int) ((long) horizontal_max * vertical_max % 1000000007);
	}
}
