package array.sorted;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSmallestCommonElementInAllRows {

	/*
	 * Given an m x n matrix mat where every row is sorted in strictly
	 * increasing order, return the smallest common element in all rows.
	 * 
	 * If there is no common element, return -1.
	 * 
	 * 
	 */
	private final Map<Integer, Integer> map = new HashMap<>();

	// O(MN), O(MN) space
	public int smallestCommonElement(int[][] mat) {
		int smallest = Integer.MAX_VALUE;
		int height = mat.length;
		int width = mat[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int freq = map.getOrDefault(mat[i][j], 0) + 1;
				map.put(mat[i][j], freq);
				if (freq == height) {
					if (mat[i][j] < smallest)
						smallest = mat[i][j];
				}
			}
		}
		return smallest == Integer.MAX_VALUE ? -1 : smallest;
	}

	// O(MNlogM)
	public int smallestCommonElement2(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		if (m == 1)
			return mat[0][0];
		for (int i = 0; i < n; i++) {
			int num = mat[0][i];
			boolean found = true;
			for (int j = 1; j < m && found; j++) {
				if (Arrays.binarySearch(mat[j], num) < 0)
					found = false;
			}
			if (found) {
				return num;
			}
		}
		return -1;
	}

	// O(MN), need re-write
	public int smallestCommonElement3(int[][] mat) {
		int h = mat.length;
		int w = mat[0].length;
		int cur_max = 0;
		int cnt = 0;
		int[] pos = new int[h];
		while (true) {
			for (int i = 0; i < h; i++) {
				while (pos[i] < w && mat[i][pos[i]] < cur_max)
					pos[i]++;
				if (pos[i] >= w)
					return -1;
				if (mat[i][pos[i]] > cur_max) {
					cnt = 1;
					cur_max = mat[i][pos[i]];
				} else {
					cnt++;
					if (cnt == h)
						return cur_max;
				}
			}
		}
	}
}
