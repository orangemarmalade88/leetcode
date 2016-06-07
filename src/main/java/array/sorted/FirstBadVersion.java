package array.sorted;

public class FirstBadVersion {

	private boolean isBadVersion(int version) {
		return false;
	}

	public int firstBadVersion(int n) {
		int start = 1;
		int end = n;
		while (start < end) {
			int mid = (start + end) >>> 1;
			if (isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}
