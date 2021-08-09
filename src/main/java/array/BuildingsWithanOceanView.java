package array;

import java.util.Iterator;
import java.util.LinkedList;

public class BuildingsWithanOceanView {
	public int[] findBuildings(int[] heights) {
		int max = 0;
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = heights.length - 1; i >= 0; i--) {
			if (heights[i] > max) {
				max = heights[i];
				list.addFirst(i);
			}
		}
		int[] res = new int[list.size()];
		Iterator<Integer> iter = list.iterator();
		for (int i = 0; i < list.size(); i++) {
			res[i] = iter.next();

		}
		return res;
	}

}
