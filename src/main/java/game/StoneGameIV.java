package game;

import java.util.HashMap;
import java.util.Map;

public class StoneGameIV {
	/*
	 * Alice and Bob take turns playing a game, with Alice starting first.
	 * 
	 * Initially, there are n stones in a pile. On each player's turn, that
	 * player makes a move consisting of removing any non-zero square number of
	 * stones in the pile.
	 * 
	 * Also, if a player cannot make a move, he/she loses the game.
	 * 
	 * Given a positive integer n. Return True if and only if Alice wins the
	 * game otherwise return False, assuming both players play optimally.
	 * 
	 * 
	 */
	public boolean winnerSquareGame2(int n) {
		Map<Integer, Boolean> map = new HashMap<>();
		map.put(0, false);
		map.put(1, true);
		return dfs(map, n);
	}

	private boolean dfs(Map<Integer, Boolean> map, int n) {
		if (map.containsKey(n))
			return map.get(n);
		int k = (int) Math.sqrt(n);
		for (int i = 1; i <= k; i++) {
			int s = n - i * i;
			if (!dfs(map, s)) {
				map.put(n, true);
				return true;
			}
		}
		map.put(n, false);
		return false;
	}
}
