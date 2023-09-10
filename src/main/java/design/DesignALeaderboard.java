package design;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DesignALeaderboard {

	// When using custom comparator,
	// Equals will also using comparator
	// Will also affect add, remove and such

	// Treeset won't automatically resort if its content is changed.

	public class Player {
		int playerId;
		int score;

		public Player(int playerId, int score) {
			super();
			this.playerId = playerId;
			this.score = score;
		}
	}

	Map<Integer, Player> map = new HashMap<>();
	Set<Player> set = new TreeSet<>(
			(o1, o2) -> o2.score != o1.score ? o2.score - o1.score
					: o1.playerId - o2.playerId);

	public DesignALeaderboard() {

	}

	public void addScore(int playerId, int score) {
		if (!map.containsKey(playerId)) {
			Player n = new Player(playerId, score);
			map.put(playerId, n);
			set.add(n);
		} else {
			Player p = map.get(playerId);
			set.remove(p);
			p.score = p.score + score;
			set.add(p);
		}
	}

	public int top(int K) {
		int score = 0;
		Iterator<Player> it = set.iterator();
		while (K-- > 0 && it.hasNext()) {
			score += it.next().score;
		}
		return score;
	}

	public void reset(int playerId) {
		Player p = map.get(playerId);
		map.remove(playerId);
		set.remove(p);
	}

	public static void main(String[] args) {
		DesignALeaderboard d = new DesignALeaderboard();
		d.addScore(1, 13);
		d.addScore(2, 93);
		d.addScore(3, 84);
		d.addScore(4, 6);
		d.addScore(5, 89);
		d.addScore(6, 31);
		d.addScore(7, 7);
		d.addScore(8, 1);
		d.addScore(9, 98);
		d.addScore(10, 42);

		d.top(5);
		d.reset(1);
		d.reset(2);
		d.addScore(3, 76);
		d.addScore(4, 48);
		d.top(1);

	}
}
