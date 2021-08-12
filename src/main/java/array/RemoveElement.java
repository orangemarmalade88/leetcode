package array;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int slow = 0;
		int fast = nums.length - 1;
		while (slow <= fast) {
			while (fast >= slow && nums[fast] == val)
				fast--;
			if (fast >= slow && nums[slow] == val) {
				nums[slow] = nums[fast];
				fast--;
			}
			slow++;
		}
		return fast + 1;
	}
}
