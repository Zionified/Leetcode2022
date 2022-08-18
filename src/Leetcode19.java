/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/* Always try to exploit features of arrays or lists if the requirement is not 
   intuitive at first glance. Rather use some 'brute-force' and transform the 
   request to something feasible.
*/
class Leetcode19 {

    // first find length then remove element starting from the head
    public int length(ListNode head) {
        ListNode tracker = head;
        int count = 0;
        while (tracker != null) {
            count++;
            tracker = tracker.next;
        }
        return count;
    }
    
    // 1ms 43.1mb
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if ((head == null) || (head.next == null)) {
            return null;
        }
        int len = length(head);

        // find start psn of the removal (node before target)
        int start = len - n;

        // edge case: will not enter while loop and simply return list w/o the last element
        if (start == 0) {
            return head.next;
        }

        // start counting from head
        int psn = 1;
        ListNode tracker = head;

        // find the node before the deleted node
        while (tracker != null && psn < start) {
            tracker = tracker.next;
            psn++;
        }

        // safety
        if (tracker == null || tracker.next == null) {
            return null;
        } 

        // reset nodes
        ListNode end = tracker.next.next;
        tracker.next = end;
        return head;
    }
}