package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
	/*
	 * Given an array of integers heights representing the histogram's bar
	 * height where the width of each bar is 1, return the area of the largest
	 * rectangle in the histogram.
	 * 
	 * 
	 */
	public int largestRectangleArea(int[] heights) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
					int cur = stack.pop();
					int width = stack.isEmpty() ? i : i - stack.peek() - 1;
					int cur_area = heights[cur] * (width);
					max = Math.max(max, cur_area);
				}
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			int width = stack.isEmpty() ? heights.length
					: heights.length - stack.peek() - 1;
			int cur_area = heights[cur] * (width);
			max = Math.max(max, cur_area);
		}
		return max;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
		int[] heights = { 2, 1, 2 };
		l.largestRectangleArea(heights);
	}
}
