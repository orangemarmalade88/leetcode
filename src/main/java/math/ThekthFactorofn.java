package math;

import java.util.ArrayList;
import java.util.List;

public class ThekthFactorofn {
	public int kthFactor(int n, int k) {
		List<Integer> div = new ArrayList<>();
		int sqn = (int) Math.sqrt(n);
		for (int i = 1; i <= sqn; i++) {
			if (n % i == 0) {
				div.add(i);
				k--;
			}
			if (k == 0)
				return i;
		}

		if (sqn * sqn == n)
			k++;

		for (int i = div.size() - 1; i >= 0; i--) {
			k--;
			if (k == 0)
				return n / div.get(i);
		}
		return -1;
	}
}
