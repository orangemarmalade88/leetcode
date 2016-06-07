package math;

import java.util.LinkedList;
import java.util.Queue;

/*

 Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number.

 */

public class UglyNumberII {
	public int nthUglyNumber(int n) {
		Queue<Integer> two = new LinkedList<>();
		Queue<Integer> three = new LinkedList<>();
		Queue<Integer> five = new LinkedList<>();

		two.add(1);
		int min = 1;
		for (int i = 2; i <= n; i++) {
			int two_c = two.isEmpty() ? Integer.MAX_VALUE : two.peek() * 2;
			int three_c = three.isEmpty() ? Integer.MAX_VALUE
					: three.peek() * 3;
			int five_c = five.isEmpty() ? Integer.MAX_VALUE : five.peek() * 5;

			min = Math.min(Math.min(two_c, three_c), five_c);
			if (two_c == min)
				three.add(two.poll());

			if (three_c == min)
				five.add(three.poll());
			if (five_c == min)
				five.poll();

			two.add(min);
		}
		return min;
	}

	public static void main(String[] args) {
		new UglyNumberII().nthUglyNumber(5);
	}
}
