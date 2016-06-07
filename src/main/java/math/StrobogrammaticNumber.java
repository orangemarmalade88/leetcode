package math;

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		int begin = 0;
		int end = num.length() - 1;
		while (begin <= end) {
			int b = Character.getNumericValue(num.charAt(begin));
			int e = Character.getNumericValue(num.charAt(end));
			if (b != e) {
				if (b + e != 15 || b * e != 54)
					return false;
			} else {
				if (b != 1 && b != 8 && b != 0)
					return false;
			}
			begin++;
			end--;
		}
		return true;
	}
}
