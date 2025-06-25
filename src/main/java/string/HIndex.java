package string;

import java.util.Arrays;

public class HIndex {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);

		int h = 0;
		while (h < citations.length && citations[citations.length - h - 1] > h)
			h++;
		return h;
	}
}
