package string;

public class DecodeWays {
	public int numDecodings(String s) {
		int l = s.length();

		int[] ways = new int[s.length() + 1];
		if (l == 0)
			return 0;
		ways[0] = 1;
		if (l >= 1) {
			ways[1] = s.charAt(0) == '0' ? 0 : 1;
		}

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != '0')
				ways[i + 1] += ways[i];
			int num = Integer.parseInt(s.substring(i - 1, i + 1));
			if (num >= 10 && num <= 26)
				ways[i + 1] += ways[i - 1];
		}

		return ways[s.length()];
	}

	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		dw.numDecodings("10");
	}
}
