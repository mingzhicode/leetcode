/**
 * @author mingzhi
 * @date 2020-11-21
 */
public class Solution148 {


    public ListNode sortList(ListNode head) {
        return mergeSortRecursion(head);
    }

    private ListNode InsertSort(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode sortedNode = head, curr = head.next;
        while (curr != null) {
            if (curr.val >= sortedNode.val) {
                sortedNode = sortedNode.next;
            }else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                sortedNode.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = sortedNode.next;
        }
        return dummyHead.next;
    }

    public ListNode mergeSortRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddleNode(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = mergeSortRecursion(head);
        ListNode right = mergeSortRecursion(rightHead);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            }else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left != null ? left : right;
        return dummy.next;
    }

    private ListNode findMiddleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast != null ? slow.next : slow;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
}
