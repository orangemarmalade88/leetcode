package list;

public class TrappingRainWater {
	/*
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it can trap after raining.
	 * 
	 * 
	 */
	// Two pointers O(N) O(1) space
	public int trap3(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int left_max = 0;
		int right_max = 0;
		int ans = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= left_max) {
					left_max = height[left];
				} else {
					ans += left_max - height[left];
				}
				left++;
			} else {
				if (height[right] >= right_max) {
					right_max = height[right];
				} else {
					ans += right_max - height[right];
				}
				right--;
			}
		}
		return ans;
	}

	// DP O(N) O(N) space
	public int trap2(int[] height) {
		int ans = 0;
		int l = height.length;
		if (l < 2)
			return ans;
		int dp_left[] = new int[l];
		int dp_right[] = new int[l];
		dp_left[0] = height[0];
		for (int i = 1; i < l; i++) {
			dp_left[i] = Math.max(height[i], dp_left[i - 1]);
		}
		dp_right[l - 1] = height[l - 1];
		for (int i = l - 2; i >= 0; i--) {
			dp_right[i] = Math.max(height[i], dp_right[i + 1]);
		}

		for (int i = 0; i < height.length; i++) {
			ans += Math.min(dp_left[i], dp_right[i]) - height[i];
		}
		return ans;
	}

	// Brute force, O(N^2)
	public int trap(int[] height) {
		int ans = 0;
		for (int i = 0; i < height.length; i++) {
			int left_max = 0;
			int right_max = 0;
			for (int j = i; j >= 0; j--) {
				left_max = Math.max(left_max, height[j]);
			}
			for (int j = i; j < height.length; j++) {
				right_max = Math.max(right_max, height[j]);
			}
			ans += Math.min(left_max, right_max) - height[i];
		}
		return ans;
	}
}
