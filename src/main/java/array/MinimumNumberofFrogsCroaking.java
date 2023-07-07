package array;

public class MinimumNumberofFrogsCroaking {

	public int minNumberOfFrogs(String croakOfFrogs) {
		int frogs = 0;
		int max_frogs = 0;
		int[] states = new int[5];
		for (int i = 0; i < croakOfFrogs.length(); i++) {
			char c = croakOfFrogs.charAt(i);
			int n = "croak".indexOf(c);
			if (n == 0) {
				frogs++;
				max_frogs = Math.max(max_frogs, frogs);
				states[0]++;
			} else if (n == 4) {
				if (states[3] <= 0)
					return -1;
				states[3]--;
				frogs--;
			} else {
				if (states[n - 1] <= 0)
					return -1;
				states[n - 1]--;
				states[n]++;
			}
		}
		return frogs == 0 ? max_frogs : -1;
	}
}
