package array;

import java.util.HashMap;
import java.util.Map;

public class DotProductOfTwoSparseVectors {

	/*
	 * 1570. Dot Product of Two Sparse Vectors
	 *
	 * Given two sparse vectors, compute their dot product.
	 *
	 * Implement class SparseVector:
	 *
	 * SparseVector(nums) Initializes the object with the vector nums
	 * dotProduct(vec) Compute the dot product between the instance of
	 * SparseVector and vec A sparse vector is a vector that has mostly zero
	 * values, you should store the sparse vector efficiently and compute the
	 * dot product between two SparseVector.
	 *
	 * Follow up: What if only one of the vectors is sparse?
	 *
	 *
	 */
	public class SparseVector {
		HashMap<Integer, Integer> map;

		SparseVector(int[] nums) {
			map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					map.put(i, nums[i]);
				}
			}
		}

		// Return the dotProduct of two sparse vectors
		public int dotProduct(SparseVector vec) {
			int total = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				total += entry.getValue()
						* vec.map.getOrDefault(entry.getKey(), 0);
			}
			return total;
		}
	}
}
