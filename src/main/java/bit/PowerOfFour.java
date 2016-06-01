package bit;

/*

 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?

 */

public class PowerOfFour {

	boolean isPowerOfFour2(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
	}

	boolean isPowerOfFour(int n) {

		// need n > 0 for overflow cases
		if (n > 0 && (n & (n - 1)) == 0) {
			int count = 0;
			while (n > 1) {
				n >>= 1;
				count++;
			}
			return (count & 1) == 0;
		}
		return false;
	}
}
