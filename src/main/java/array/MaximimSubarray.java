package array;

public class MaximimSubarray {
    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int max_until_now = nums[0];

        for (int i = 1; i < nums.length; i++) {

            max_until_now = max_until_now > 0 ? max_until_now + nums[i]
                    : nums[i];
            max_so_far = Math.max(max_until_now, max_so_far);
        }
        return max_so_far;
    }
}
