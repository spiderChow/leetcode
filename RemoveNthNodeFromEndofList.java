/*

19. Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.

*/

/*
第一次 我做的时候是很naive的放一个arraylist,将每一个节点放进去这样就可以get(size()-n)这个样子拿出相应的节点
但是这样空间复杂度就会增加
比较好的one pass方法是利用指针作为游标，一个fast一个slow，先使之相差n，
然后同步往后移动直到fast到末尾，这样就可以取得倒数nth
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(-1);
        ListNode slow = start;
        ListNode fast = start;
        start.next = head;
        for(int i =0;i<n;i++){
            fast = fast.next;
        }
        while(fast.next!=null){ //fast is not the last one
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}