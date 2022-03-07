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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode left = list1;
        ListNode right = list2;
        ListNode node = new ListNode(-1), temp;
        ListNode head = node;
        while(left != null && right != null) {  
            if(left.val < right.val) {
                temp = left;
                left = left.next;
            } else {
                temp = right;
                right = right.next;
            }
            node.next = temp;
            node = node.next;
        }
        
        while(left != null) {
            node.next = left;
            node = node.next;
            left = left.next;
        }
        
        while(right != null) {
            node.next = right;
            node = node.next;
            right = right.next;
        }
        return head.next;
    }
}