package array;

public class ClosestDessertCost {

	int closestCost;

	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		closestCost = baseCosts[0];

		for (int i = 0; i < baseCosts.length; i++) {
			dfs(toppingCosts, 0, target, baseCosts[i]);
		}
		return closestCost;
	}

	public void dfs(int[] toppingCosts, int index, int target, int total) {

		if (Math.abs(total - target) < Math.abs(closestCost - target)) {
			closestCost = total;
		}
		if (Math.abs(total - target) == Math.abs(closestCost - target)
				&& total < closestCost) {
			closestCost = total;
		}
		if (total >= target || index >= toppingCosts.length) {
			return;
		}
		dfs(toppingCosts, index + 1, target, total);
		dfs(toppingCosts, index + 1, target, total + toppingCosts[index]);
		dfs(toppingCosts, index + 1, target,
				total + toppingCosts[index] + toppingCosts[index]);
	}
}
