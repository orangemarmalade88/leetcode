package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class DesignTwitter {

	Map<Integer, List<int[]>> tweetsMap = new HashMap<>();
	// user-id -> tweets [timestamp, tweetId]

	Map<Integer, Set<Integer>> subMap = new HashMap<>();
	// user-id -> s;
	int timestamp = 0;

	public DesignTwitter() {

	}

	public void postTweet(int userId, int tweetId) {
		List<int[]> tweet = tweetsMap.get(userId);
		if (tweet == null)
			tweet = new ArrayList<>();
		tweet.add(new int[] { timestamp, tweetId });
		timestamp++;
		tweetsMap.put(userId, tweet);
	}

	public List<Integer> getNewsFeed(int userId) {
		Set<Integer> subs = subMap.get(userId);
		if (subs == null)
			subs = new HashSet<>();
		subs.add(userId);

		List<List<int[]>> tweets = new ArrayList<>();
		for (int i : subs) {
			tweets.add(tweetsMap.get(i));
		}

		return getTop10(tweets);
	}

	private List<Integer> getTop10(List<List<int[]>> tweets) {
		Queue<int[]> q = new PriorityQueue<>(((o1, o2) -> o2[3] - o1[3]));
		// index[long] -> value -> index[short] -> timestamp

		for (int i = 0; i < tweets.size(); i++) {
			if (tweets.get(i) != null && tweets.get(i).size() > 0) {
				int last = tweets.get(i).size() - 1;
				q.add(new int[] { i, tweets.get(i).get(last)[1], last,
						tweets.get(i).get(last)[0] });
			}
		}

		List<Integer> res = new ArrayList<>();
		while (res.size() < 10 && q.size() > 0) {
			int[] cur = q.poll();
			res.add(cur[1]);
			int id = cur[0];
			int index = cur[2];
			if (index > 0) {
				q.add(new int[] { id, tweets.get(id).get(index - 1)[1],
						index - 1, tweets.get(id).get(index - 1)[0] });
			}
		}

		return res;
	}

	public void follow(int followerId, int followeeId) {
		Set<Integer> subs = subMap.get(followerId);
		if (subs == null)
			subs = new HashSet<>();
		if (!subs.contains(followeeId)) {
			subs.add(followeeId);
			subMap.put(followerId, subs);
		}

	}

	public void unfollow(int followerId, int followeeId) {
		Set<Integer> subs = subMap.get(followerId);
		if (subs == null)
			return;
		subMap.remove(followerId);

	}
}
