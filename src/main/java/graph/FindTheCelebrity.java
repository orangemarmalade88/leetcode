package graph;

public class FindTheCelebrity {

	boolean knows(int a, int b) {
		return false;
	}

	public int findCelebrity(int n) {
		int candidate = 0;
		for (int i = 1; i < n; i++) {
			if (knows(candidate, i))
				candidate = i;
		}

		return -1;
	}
}
