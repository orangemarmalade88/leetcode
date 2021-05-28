package math;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {
	/*
	 * Implement the class ProductOfNumbers that supports two methods:
	 *
	 * 1. add(int num)
	 *
	 * Adds the number num to the back of the current list of numbers. 2.
	 * getProduct(int k)
	 *
	 * Returns the product of the last k numbers in the current list. You can
	 * assume that always the current list has at least k numbers. At any time,
	 * the product of any contiguous sequence of numbers will fit into a single
	 * 32-bit integer without overflowing.
	 *
	 *
	 */
	List<Integer> products;

	public ProductOfTheLastKNumbers() {
		products = new ArrayList<Integer>();
		products.add(1);
	}

	// O(1)
	public void add(int num) {
		if (num != 0) {
			int p = num * products.get(products.size() - 1);
			products.add(p);
		} else {
			products.clear();
			products.add(1);
		}
	}

	// O(1)
	public int getProduct(int k) {
		if (products.size() - k - 1 < 0)
			return 0;
		return products.get(products.size() - 1)
				/ products.get(products.size() - k - 1);
	}
}
