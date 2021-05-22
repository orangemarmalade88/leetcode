package math;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {
	List<Integer> products;

	public ProductOfTheLastKNumbers() {
		products = new ArrayList<>(40000);
		products.add(1);
	}

	public void add(int num) {
		if (num == 0)
			products.clear();
		else
			products.add(products.get(products.size() - 1) * num);
	}

	public int getProduct(int k) {
		int n = products.size();
		return products.get(n - 1) / products.get(n - 1 - k);
	}

	public static void main(String[] args) {
		ProductOfTheLastKNumbers p = new ProductOfTheLastKNumbers();
		p.add(3);
		p.add(0);
		p.add(2);
		p.add(5);
		p.add(4);
		p.getProduct(2);
		p.getProduct(3);
		p.getProduct(4);
	}
}
