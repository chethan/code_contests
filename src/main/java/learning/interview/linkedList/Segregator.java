package learning.interview.linkedList;

import ds.ListNode;

class Segregator {
    /*
        Segregate even and odd elements in place
    */
    ListNode evenOdd(ListNode node) {
        ListNode oddMarker = node, evenMarker = node.next;
        if (node.next == null) {
            return node;
        }
        while (evenMarker != null) {
            if ((oddMarker.val & 1) != 0) {
                oddMarker = oddMarker.next;
                if (evenMarker == oddMarker) {
                    evenMarker = evenMarker.next;
                }
            } else {
                int temp = evenMarker.val;
                evenMarker.val = oddMarker.val;
                oddMarker.val = temp;
                evenMarker = evenMarker.next;
            }
        }
        return node;

    }
}
