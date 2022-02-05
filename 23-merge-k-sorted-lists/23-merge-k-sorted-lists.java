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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre =  new ListNode(-1);
        ListNode ans = pre;
        boolean loop = true;
        while(loop) {
            ListNode node = findMin(lists);
            pre.next = node;
            pre = node;
            if(pre == null) loop = false;
        }
        return ans.next;
    }
    
    public ListNode findMin(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        ListNode minNode = null;
        for(int i=0; i<lists.length; i++) {
            if(lists[i] != null && min > lists[i].val) {
                index = i;
                min = lists[i].val;
            }
        }
        if(index >= 0) {
            minNode = lists[index];
            lists[index] = lists[index].next;
        }
        return minNode;
    }
}