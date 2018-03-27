/*

2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/

/*
很容易实现，不过要是代码优雅一点就需要点心思，下面的这是看过一个高票代码后自己写的
sum/10 得到十分位的数字
sum%10 得到个位的数字

注意最后判断sum/10是否为1，看最高位是否进位

循环 判断 while(l1!=null || l2 !=null){
	只要有个不是null，就加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode n = head;
        int sum= 0;
        while(l1!=null || l2 !=null){
            sum = sum/10;
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            n.next = new ListNode(sum%10);
            n = n.next;
        }
        if(sum/10==1){
            n.next = new ListNode(1);
        }
        
        
        return head.next;
    }
}