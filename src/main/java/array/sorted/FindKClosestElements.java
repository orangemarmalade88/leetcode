package array.sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		int right = Arrays.binarySearch(arr, x);
		if (right < 0)
			right = -right - 1;
		int left = right - 1;
		while (right - left < k + 1) {
			if (right >= arr.length && left < 0)
				break;
			if (left < 0) {
				right++;
			} else if (right >= arr.length) {
				left--;
			} else {
				int l = arr[left];
				int r = arr[right];
				if (Math.abs(l - x) <= Math.abs(r - x))
					left--;
				else
					right++;
			}
		}
		for (int i = left + 1; i < right; i++) {
			res.add(arr[i]);
		}
		return res;
	}
}
