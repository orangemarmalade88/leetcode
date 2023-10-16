package array;

public class CuttingRibbons {
	public int maxLength(int[] ribbons, int k) {
		if (!canCut(ribbons, 1, k))
			return 0;

		int low = 1;
		int high = 0;
		for (int i : ribbons) {
			high = Math.max(high, i);
		}

		while (low < high) {
			int mid = (low + high + 1) / 2;
			if (!canCut(ribbons, mid, k)) {
				high = mid - 1;
			} else {
				low = mid;
			}
		}
		return low;
	}

	public boolean canCut(int[] ribbons, int length, int k) {
		int count = 0;
		for (int i : ribbons) {
			count += i / length;
			if (count >= k)
				return true;
		}
		return false;
	}
}
