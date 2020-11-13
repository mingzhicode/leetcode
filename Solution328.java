/**
 * @author mingzhi
 * @date 2020-11-13
 */
public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        return cleanSolution(head);
    }

    private ListNode cleanSolution(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    private ListNode splitAndMerge(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddNodeHead = new ListNode();
        ListNode evenNodeHead = new ListNode();

        ListNode oddNode = head, evenNode = head.next;
        oddNodeHead.next = oddNode;
        evenNodeHead.next = evenNode;
        if (evenNode == null) {
            return head;
        }
        ListNode lastOddNode = null;
        while (oddNode != null && evenNode != null) {
            oddNode.next = evenNode.next;
            if (oddNode.next == null) {
                lastOddNode = oddNode;
            }
            oddNode = oddNode.next;
            if (oddNode == null) {
                evenNode.next = null;
            }else {
                evenNode.next = oddNode.next;
                evenNode = evenNode.next;
            }
        }
        if (lastOddNode != null) {
            lastOddNode.next = evenNodeHead.next;
        }else {
            oddNode.next = evenNodeHead.next;
        }
        return oddNodeHead.next;
    }



    private class ListNode {
        int val;
        ListNode next;
        ListNode () {

        }
        ListNode (int val) {
            this.val = val;
        }
        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
