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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a sentinel dummy head to track the start of the result list
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        // Loop until both lists are fully traversed and no carry remains
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // Add value from the first list if it exists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from the second list if it exists
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate new carry and the single digit value for the current node
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            
            // Advance the result pointer
            curr = curr.next;
        }

        // Return the actual head of the sum list
        return dummyHead.next;
    }
}
