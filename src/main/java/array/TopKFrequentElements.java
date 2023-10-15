package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	class Data {
		int num;
		int count;

		public Data(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}

	}

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		List<Data> list = new ArrayList<>();
		for (Integer i : map.keySet()) {
			list.add(new Data(i, map.get(i)));
		}

		quickSelect(list, 0, list.size() - 1, k);
		int[] res = new int[k];
		int j = 0;
		for (int i = list.size() - k; i < list.size(); i++) {
			res[j++] = list.get(i).num;
		}
		return res;
	}

	private void quickSelect(List<Data> list, int start, int end, int k) {
		int pivot = list.get(end).count;
		int swap_index = start;

		for (int i = start; i < end; i++) {
			if (list.get(i).count < pivot) {
				Collections.swap(list, swap_index, i);
				swap_index++;
			}
		}

		Collections.swap(list, end, swap_index);

		if (k == end - swap_index + 1)
			return;
		if (k < end - swap_index + 1) {
			quickSelect(list, swap_index + 1, end, k);
		} else
			quickSelect(list, start, swap_index - 1,
					k - (end - swap_index + 1));
	}
}
