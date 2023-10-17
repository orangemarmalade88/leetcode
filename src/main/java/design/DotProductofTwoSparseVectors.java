package design;

import java.util.HashMap;
import java.util.Map;

public class DotProductofTwoSparseVectors {

	Map<Integer, Integer> map = new HashMap<>();

	DotProductofTwoSparseVectors(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			map.put(i, nums[i]);
		}
	}

	// Return the dotProduct of two sparse vectors
	public int dotProduct(DotProductofTwoSparseVectors vec) {
		int sum = 0;
		for (int id : vec.map.keySet()) {
			if (this.map.containsKey(id)) {
				sum += vec.map.get(id) * this.map.get(id);
			}
		}
		return sum;
	}
}
