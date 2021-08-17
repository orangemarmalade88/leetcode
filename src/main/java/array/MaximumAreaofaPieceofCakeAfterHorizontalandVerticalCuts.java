package array;

import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		int maxH = 0;
		Arrays.sort(horizontalCuts);
		for (int i = 1; i < horizontalCuts.length; i++) {
			maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
		}
		maxH = Math.max(maxH, horizontalCuts[0]);
		maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);

		int maxV = 0;
		Arrays.sort(verticalCuts);
		for (int i = 1; i < verticalCuts.length; i++) {
			maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i - 1]);
		}
		maxV = Math.max(maxV, verticalCuts[0]);
		maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);

		long area = (long) maxH * (long) maxV;
		return (int) (area % (1000000007));
	}
}
