package array;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int id1 = m - 1;
		int id2 = n - 1;

		int id3 = m + n - 1;

		while (id1 >= 0 && id2 >= 0) {
			if (nums2[id2] >= nums1[id1]) {
				nums1[id3--] = nums2[id2--];
			} else {
				nums1[id3--] = nums1[id1--];
			}
		}

		while (id2 >= 0) {
			nums1[id3--] = nums2[id2--];
		}

	}
}
