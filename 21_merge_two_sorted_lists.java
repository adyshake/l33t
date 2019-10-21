//https://leetcode.com/problems/merge-two-sorted-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode res;
        
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        
        if (l1.val <= l2.val) {
            head = l1;
            res = l1;
            l1 = l1.next;
        }
        else {
            head = l2;
            res = l2;
            l2 = l2.next;
        }
            
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            }
            else {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            }
        }
        
        while (l1 != null) {
            res.next = l1;
            res = res.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            res.next = l2;
            res = res.next;
            l2 = l2.next;
        }
        
        return head;
    }
}