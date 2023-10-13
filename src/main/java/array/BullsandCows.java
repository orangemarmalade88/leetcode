package array;

public class BullsandCows {
	public String getHint(String secret, String guess) {
		int[] dictS = new int[10];
		int[] dictG = new int[10];

		int a = 0;

		for (int i = 0; i < secret.length(); i++) {
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if (s == g)
				a++;
			dictS[s - '0']++;
			dictG[g - '0']++;
		}

		int b = 0;
		for (int i = 0; i <= 9; i++) {
			b += Math.min(dictS[i], dictG[i]);
		}

		b -= a;

		return a + "A" + b + 'B';
	}
}
