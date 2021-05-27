package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RussianDollEnvelopes {
	/*
	 * You are given a 2D array of integers envelopes where envelopes[i] = [wi,
	 * hi] represents the width and the height of an envelope.
	 * 
	 * One envelope can fit into another if and only if both the width and
	 * height of one envelope are greater than the other envelope's width and
	 * height.
	 * 
	 * Return the maximum number of envelopes you can Russian doll (i.e., put
	 * one inside the other).
	 * 
	 * Note: You cannot rotate an envelope.
	 * 
	 * 
	 */
	// O(NlogN), lengthofLIS
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int size = 0;
		for (int i : nums) {
			int index = Arrays.binarySearch(dp, 0, size, i);
			if (index < 0)
				index = -(index + 1);
			dp[index] = i;
			if (index == size)
				size++;
		}
		return size;
	}

	public int maxEnvelopes2(int[][] envelopes) {
		Arrays.sort(envelopes, new Comparator<>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0])
					return a[0] - b[0];
				return b[1] - a[1];
			}
		});

		int[] dim2 = new int[envelopes.length];
		for (int i = 0; i < envelopes.length; i++)
			dim2[i] = envelopes[i][1];
		return lengthOfLIS(dim2);
	}

	// O(N^2) dp
	public int maxEnvelopes(int[][] envelopes) {
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < envelopes.length; i++) {
			max = Math.max(max, dfs(envelopes, i, map));
		}
		return max;
	}

	public int dfs(int[][] envelopes, int i, Map<Integer, Integer> map) {
		int max = 0;
		for (int j = 0; j < envelopes.length; j++) {
			if (canFit(envelopes[i], envelopes[j])) {
				if (map.containsKey(j)) {
					max = Math.max(max, map.get(j));
				} else {
					int res = dfs(envelopes, j, map);
					map.put(j, res);
					max = Math.max(max, res);
				}
			}
		}
		return max + 1;
	}

	public boolean canFit(int[] i, int[] j) {
		return i[0] < j[0] && i[1] < j[1];
	}
}
