package ds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chethan on 11/2/15.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    public static ListNode from(int... values) {
        ListNode previousNode = null, headNode = null;
        for (int i = 0; i < values.length; i++) {
            ListNode listNode = new ListNode(values[i]);
            if (previousNode != null) previousNode.next = listNode;
            previousNode = listNode;
            if (i == 0) headNode = listNode;
        }
        return headNode;
    }

    public List<Integer> toArray() {
        List<Integer> values = new ArrayList<>();
        ListNode listNode = this;
        while (listNode != null) {
            values.add(listNode.val);
            listNode = listNode.next;
        }
        return values;
    }

    public static ListNode.Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final ListNode listNode;

        public Builder() {
            listNode = new ListNode();
        }

        public Builder val(int value) {
            listNode.val = value;
            return this;
        }

        public Builder next(ListNode value) {
            listNode.next = value;
            return this;
        }

        public ListNode build() {
            return listNode;
        }
    }


}
