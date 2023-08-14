package array;

public class PeakIndexinaMountainArray {
	public static int peakIndexInMountainArray(int[] arr) {
		int low = 0;
		int high = arr.length - 1;

		while (low < high) {
			int mid = (low + high) / 2;
			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		int[] input = { 3, 5, 3, 2, 0 };
		peakIndexInMountainArray(input);
	}
}
