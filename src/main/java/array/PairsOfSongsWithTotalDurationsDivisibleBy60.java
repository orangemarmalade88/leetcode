package array;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
	/*
	 * 1010. Pairs of Songs With Total Durations Divisible by 60
	 *
	 * You are given a list of songs where the ith song has a duration of
	 * time[i] seconds.
	 *
	 * Return the number of pairs of songs for which their total duration in
	 * seconds is divisible by 60. Formally, we want the number of indices i, j
	 * such that i < j with (time[i] + time[j]) % 60 == 0.
	 *
	 * 应该加到map的时候就计算 pairs map可以用 int[60] 比较好
	 */
	public int numPairsDivisibleBy60(int[] time) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < time.length; i++) {
			int mod = time[i] % 60;
			map.put(mod, map.getOrDefault(mod, 0) + 1);
		}
		int total = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int mod = entry.getKey();
			if (mod != 0 && mod != 30) {
				if (map.containsKey(60 - mod)) {
					total += entry.getValue() * map.get(60 - mod);
				}
			}
		}
		total /= 2;
		if (map.containsKey(0)) {
			int value = map.get(0);
			total += value * (value - 1) / 2;
		}
		if (map.containsKey(30)) {
			int value = map.get(30);
			total += value * (value - 1) / 2;
		}
		return total;
	}
}
