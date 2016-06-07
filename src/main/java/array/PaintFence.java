package array;

public class PaintFence {
	public int numWays(int n, int k) {
		int[] noAdj = new int[n];
		int[] withAdj = new int[n];

		noAdj[0] = k;
		withAdj[0] = 0;

		for (int i = 1; i < n; i++) {
			noAdj[i] = (k - 1) * noAdj[i - 1];
			withAdj[i] = (k - 1) * withAdj[i - 1] + noAdj[i - 1];
		}

		return noAdj[n - 1] + withAdj[n - 1];

	}
}
