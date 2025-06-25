package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		int right = Arrays.binarySearch(arr, x);
		if (right < 0) {
			right = -(right + 1);
		}
		int left = right - 1;
		int count = 0;
		while (count < k) {
			if (left < 0) {
				result.add(arr[right++]);
			} else if (right >= arr.length) {
				result.add(arr[left--]);
			} else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
				result.add(arr[left--]);
			} else {
				result.add(arr[right++]);

			}
		}
		Collections.sort(result);
		return result;
	}
}
