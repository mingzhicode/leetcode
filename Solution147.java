

/**
 * @author mingzhi
 * @date 2020-11-20
 */
public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, point = head.next;
        while (point != null) {
            if (lastSorted.val <= point.val) {
                lastSorted = lastSorted.next;
            }else {
                ListNode prev = dummyHead;
                while (prev.next.val <= point.val) {
                    prev = prev.next;
                }
                lastSorted.next = point.next;
                point.next = prev.next;
                prev.next = point;
            }
            point = lastSorted.next;
        }
        return dummyHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
