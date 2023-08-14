package array;

public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int h) {
		int low = 1;
		int high = 0;

		for (int i : piles) {
			high = Math.max(high, i);
		}

		while (low < high) {
			int mid = (low + high) / 2;
			if (canFinish(piles, mid, h)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public boolean canFinish(int[] piles, int speed, int h) {
		int time = 0;
		for (int i : piles) {
			time += i / speed;
			time += i % speed == 0 ? 0 : 1;
		}
		return time <= h;
	}
}
