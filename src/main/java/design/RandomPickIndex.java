package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex {

	Map<Integer, List<Integer>> map = new HashMap<>();
	Random r = new Random();

	public RandomPickIndex(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new ArrayList<>());
			}
			map.get(nums[i]).add(i);
		}
	}

	public int pick(int target) {
		List<Integer> ids = map.get(target);
		return ids.get(r.nextInt(ids.size()));
	}
}
