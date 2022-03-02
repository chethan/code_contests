package leetcode.array;

import java.util.List;

//https://leetcode.com/problems/nested-list-weight-sum/
public class NestedList {

    //Time: O(N) where n indicates count of nested elements(lists and integers)
    //Space: O(N)
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    int helper(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (NestedInteger nestedInt : nestedList) {
            if (nestedInt.isInteger()) {
                sum += (nestedInt.getInteger() * depth);
            } else {
                sum += helper(nestedInt.getList(), depth + 1);
            }
        }
        return sum;
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    private static interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
