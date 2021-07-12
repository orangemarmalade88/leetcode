package array.sorted;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumInitialEnergyToFinishTasks {
	/*
	 * You are given an array tasks where tasks[i] = [actuali, minimumi]:
	 * 
	 * actuali is the actual amount of energy you spend to finish the ith task.
	 * minimumi is the minimum amount of energy you require to begin the ith
	 * task. For example, if the task is [10, 12] and your current energy is 11,
	 * you cannot start this task. However, if your current energy is 13, you
	 * can complete this task, and your energy will be 3 after finishing it.
	 * 
	 * You can finish the tasks in any order you like.
	 * 
	 * Return the minimum initial amount of energy you will need to finish all
	 * the tasks.
	 * 
	 * 
	 */
	public int minimumEffort(int[][] tasks) {
		Arrays.sort(tasks, new Comparator<>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				return (t2[1] - t2[0]) - (t1[1] - t1[0]);
			}
		});

		int left = 0;
		for (int[] t : tasks) {
			left += t[0];
		}
		int right = 0;
		for (int[] t : tasks) {
			right += t[1];
		}

		return binarySearch(tasks, left, right);
	}

	private boolean enoughEnergy(int[][] tasks, int energy) {
		for (int i = 0; i < tasks.length; i++) {
			if (energy >= tasks[i][1]) {
				energy -= tasks[i][0];
			} else {
				return false;
			}
		}
		return true;
	}

	private int binarySearch(int[][] tasks, int left, int right) {
		while (left < right) {
			int mid = (left + right) / 2;
			if (enoughEnergy(tasks, mid)) {
				right = mid;
			} else
				left = mid + 1;
		}
		return left;
	}

	public static void main(String[] args) {
		MinimumInitialEnergyToFinishTasks a = new MinimumInitialEnergyToFinishTasks();
		int[][] tasks = { { 1, 3 }, { 2, 4 }, { 10, 11 }, { 10, 12 },
				{ 8, 9 } };
		a.minimumEffort(tasks);
	}
}
