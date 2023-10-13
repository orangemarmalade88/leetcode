package array;

import java.util.List;

import model.NestedInteger;

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		int sum = 0;
		for (NestedInteger i : nestedList) {
			sum += depthSum(i, 1);
		}
		return sum;
	}

	public int depthSum(NestedInteger ni, int depth) {
		int sum = 0;
		if (ni.isInteger()) {
			return ni.getInteger() * depth;
		}
		for (NestedInteger n : ni.getList()) {
			sum += depthSum(n, depth + 1);
		}
		return sum;
	}
}
