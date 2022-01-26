package leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fruit-into-baskets/
public class FruitsIntoBasket {

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0, i = 0;
        for (int j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                if (count.get(tree[i]) == 0) {
                    count.remove(tree[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public int totalFruitOptimized(int[] fruits) {
        int left = 0, right = 0, maxFruits = 0;
        Map<Integer, Integer> reverseIndex = new HashMap<>();
        while (right < fruits.length) {
            reverseIndex.put(fruits[right], right);
            if (reverseIndex.size() == 3) {
                int fruitIndexToBeRemoved = Collections.min(reverseIndex.values());
                reverseIndex.remove(fruits[fruitIndexToBeRemoved]);
                left = fruitIndexToBeRemoved + 1;

            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }
        return maxFruits;
    }
}
