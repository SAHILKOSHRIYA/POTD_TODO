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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        ListNode current = head;
        
        // Step 1: Calculate the total length of the linked list
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        
        // Step 2: Calculate the size of each part
        int partSize = length / k; // base size of each part
        int largerParts = length % k; // number of parts that should be larger by 1
        
        // Step 3: Split the linked list
        current = head;
        for (int i = 0; i < k; i++) {
            if (current == null) {
                result[i] = null; // If there are no more nodes left, the remaining parts will be null
            } else {
                result[i] = current; // Start the new part
                int currentPartSize = partSize + (i < largerParts ? 1 : 0); // Determine the size of the current part
                
                // Move to the end of the current part
                for (int j = 1; j < currentPartSize; j++) {
                    current = current.next;
                }
                
                // Break the link to the next part
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }
        }
        
        return result;
    }
}
