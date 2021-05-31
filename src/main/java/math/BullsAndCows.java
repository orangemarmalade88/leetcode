package math;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
	/*
	 * You are playing the Bulls and Cows game with your friend.
	 * 
	 * You write down a secret number and ask your friend to guess what the
	 * number is. When your friend makes a guess, you provide a hint with the
	 * following info:
	 * 
	 * The number of "bulls", which are digits in the guess that are in the
	 * correct position. The number of "cows", which are digits in the guess
	 * that are in your secret number but are located in the wrong position.
	 * Specifically, the non-bull digits in the guess that could be rearranged
	 * such that they become bulls. Given the secret number secret and your
	 * friend's guess guess, return the hint for your friend's guess.
	 * 
	 * The hint should be formatted as "xAyB", where x is the number of bulls
	 * and y is the number of cows. Note that both secret and guess may contain
	 * duplicate digits.
	 * 
	 */
	public String getHint(String secret, String guess) {
		Map<Integer, Integer> unmatched = new HashMap<>();
		int cows = 0;
		int bulls = 0;
		for (int i = 0; i < secret.length(); i++) {
			int s = secret.charAt(i) - '0';
			int g = guess.charAt(i) - '0';
			if (s == g)
				cows++;
			else {
				int u = unmatched.getOrDefault(s, 0);
				unmatched.put(s, u + 1);
				if (u < 0) {
					bulls++;
				}
				int k = unmatched.getOrDefault(g, 0);
				unmatched.put(g, k - 1);
				if (k > 0) {
					bulls++;
				}
			}
		}
		return cows + "A" + bulls + "B";
	}

}
