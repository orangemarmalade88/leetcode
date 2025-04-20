package array;

import java.util.Arrays;
import java.util.List;

public class MinimumTimetoMakeArraySumAtMostx {
	public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
		int size = nums1.size();
		int[][] combine = new int[size][2];
		for (int i = 0; i < size; i++) {
			combine[i][0] = nums1.get(i);
			combine[i][1] = nums2.get(i);
		}

		Arrays.sort(combine, (a, b) -> Integer.compare(a[1], b[1]));

		return -1;
	}
}
