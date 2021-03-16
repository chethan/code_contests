package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/evaluate-division/
public class DivisionEvaluator {

    public double[] calcEquation(List<List<String>> equations, double[] values,
        List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0), divisor = equations.get(i).get(1);
            double quotient = values[i];
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.get(dividend).put(divisor, quotient);
            graph.putIfAbsent(divisor, new HashMap<>());
            graph.get(divisor).put(dividend, 1 / quotient);
        }

        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            List<String> query = queries.get(i);
            String src = query.get(0);
            String dest = query.get(1);
            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                results[i] = -1;
                continue;
            }
            if (src.equals(dest)) {
                results[i] = 1;
                continue;
            }
            results[i] = dfs(graph, visited, src, dest, 1.0);
        }
        return results;
    }

    double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String src, String dest,
        double acc) {
        Map<String, Double> children = graph.get(src);
        if (children.containsKey(dest)) {
            return acc * children.get(dest);
        }

        double ret = -1;
        visited.add(src);
        for (String next : children.keySet()) {
            if (visited.contains(next)) {
                continue;
            }
            ret = dfs(graph, visited, next, dest, acc * children.get(next));
            if (ret != -1) {
                break;
            }
        }
        visited.remove(src);
        return ret;
    }
}
