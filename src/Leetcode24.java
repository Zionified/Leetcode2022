public class Leetcode24 {
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
    public ListNode mergeKLists(ListNode[] lists) {

// ArrayList Implementation:
//         handle base case
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
//         create result linklist and pq
        ListNode head = new ListNode(0, null);
        ListNode node = head;
        ArrayList<Integer> arrList = new ArrayList<>();
        
//         store every number in lists in pq
        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            ListNode tracker = cur;
            while (tracker != null) {
                arrList.add(tracker.val);
                tracker = tracker.next;
            }
        }
        Collections.sort(arrList);
    
//         ensure the nodes are 'connected'. If they are null, they are not connected.
        for (int i : arrList) {
            node.next = new ListNode(i, new ListNode());
            System.out.println(node.val);
            node = node.next;
        }
        if (node != null) {
            node.next = null;
        }
        // System.out.println(node.next.val);
        return head.next;

// Priority Queue implementation:
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(a-b));
        
//         store every number in lists in pq
        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            ListNode tracker = cur;
            while (tracker != null) {
                pq.add(tracker.val);
                tracker = tracker.next;
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
    
//         ensure the nodes are 'connected'. If they are null, they are not connected.
        while (!pq.isEmpty()) {
            node.next = new ListNode(pq.poll(), new ListNode());
            System.out.println(node.val);
            node = node.next;
        }
        if (node != null) {
            node.next = null;
        }
        // System.out.println(node.next.val);
        return head.next;
    }
}



class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1; result[1] = -1;
        int lo = 0, hi = nums.length - 1;
        while ((lo <= hi) && ((result[0] == -1) || (result[1] == -1))) {
            if ((nums[lo] == target) && (result[0] == -1)) {
               result[0] = lo;
            }
            if ((nums[hi] == target) && (result[1] == -1)) {
                result[1] = hi;
            }
            if (result[0] == -1) lo++;
            if (result[1] == -1) hi--;
        }
        
        return result;
    }
}