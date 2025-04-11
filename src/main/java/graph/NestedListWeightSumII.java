package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.NestedInteger;

public class NestedListWeightSumII {
    private Map<NestedInteger, Integer> map = new HashMap<>();
    private int maxDepth = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            dfs(ni, 1);
        }
        int sum = 0;
        for (Map.Entry<NestedInteger, Integer> entry : map.entrySet()) {
            sum += entry.getKey().getInteger()
                    * (maxDepth - entry.getValue() + 1);
        }
        return sum;
    }

    private void dfs(NestedInteger ni, int depth) {
        if (ni.isInteger()) {
            map.put(ni, depth);
            maxDepth = Math.max(depth, maxDepth);
            return;
        } else {
            for (NestedInteger next : ni.getList()) {
                dfs(next, depth + 1);
            }
        }
    }

}
