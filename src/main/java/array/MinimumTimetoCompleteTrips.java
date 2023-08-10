package array;

public class MinimumTimetoCompleteTrips {

	// Mistakes 1: n == trips doesn't mean answer = mid, might have smaller one
	// Mistakes 2: initial condition high = max * totalTrips

	public long minimumTime2(int[] time, int totalTrips) {
		int n = time.length;
		int trips = 0;
		int[] t = new int[n];
		long ans = 0L;
		while (trips < totalTrips) {
			for (int i = 0; i < n; i++) {
				t[i]++;
				if (t[i] == time[i]) {
					t[i] = 0;
					trips++;
				}
			}
			ans++;
		}
		return ans;
	}

	public static long minimumTime(int[] time, int totalTrips) {
		int max = 0;
		for (int i : time) {
			max = Math.max(max, i);
		}
		long low = 1;
		long high = (long) max * totalTrips;
		while (low < high) {
			long mid = (low + high) / 2;
			long n = 0;
			for (int i = 0; i < time.length; i++) {
				n += mid / time[i];
			}
			if (n < totalTrips) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		int[] time = { 2 };
		minimumTime(time, 1);
	}
}
