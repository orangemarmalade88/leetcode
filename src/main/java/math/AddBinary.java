package math;

public class AddBinary {
	public String addBinary(String a, String b) {
		int la = a.length();
		int lb = b.length();
		int max = Math.max(la, lb);
		int carry = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < max; i++) {
			int aTrue = (i < la) && (a.charAt(la - 1 - i) == '1') ? 1 : 0;
			int bTrue = (i < lb) && (b.charAt(lb - 1 - i) == '1') ? 1 : 0;
			int sum = aTrue + bTrue + carry;
			sb.append(sum & 1);
			carry = sum >> 1;
		}
		if (carry > 0)
			sb.append(carry);

		return sb.reverse().toString();
	}
}
