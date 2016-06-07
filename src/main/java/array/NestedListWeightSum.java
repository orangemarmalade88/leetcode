package array;

import java.util.List;

import model.NestedInteger;

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		int sum = 0;
		for (NestedInteger ni : nestedList) {
			sum += depthSum(ni, 1);
		}
		return sum;
	}

	private int depthSum(NestedInteger nestedInteger, int currentDepth) {
		if (nestedInteger.isInteger())
			return nestedInteger.getInteger() * currentDepth;
		else {
			int sum = 0;
			for (NestedInteger ni : nestedInteger.getList()) {
				sum += depthSum(ni, currentDepth + 1);
			}
			return sum;
		}

	}
}
