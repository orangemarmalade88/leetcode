public class SortColors {

	// 2 pointers 1 pass
	public void sortColors2(int[] nums) {
		int forward = 0;
		int backward = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] == 2 && i < backward) {
				nums[i] = nums[backward];
				nums[backward--] = 2;
			}

			// think again why this prevents boundary conditions
			while (nums[i] == 0 && i > forward) {
				nums[i] = nums[forward];
				nums[forward++] = 0;
			}
		}
	}

	// bucket sort 2 pass
	public void sortColors(int[] nums) {
		int[] colors = new int[3];
		for (int c : nums) {
			colors[c]++;
		}

		int ptr = 0;
		for (int i = 0; i < 3; i++) {
			int count = colors[i];
			for (int j = 0; j < count; j++) {
				nums[ptr++] = i;
			}
		}
	}
}
