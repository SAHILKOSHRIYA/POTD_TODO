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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        // Start the matching process from the root
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    // Helper function to check if we can find the linked list starting from a given tree node
    private boolean dfs(ListNode head, TreeNode node) {
        if (head == null) return true;  // Reached the end of the linked list, so it's a match
        if (node == null) return false; // Reached the end of the tree path without matching
        
        // Check if current node matches the current linked list node value
        if (head.val == node.val) {
            // Continue checking downwards in both left and right children
            return dfs(head.next, node.left) || dfs(head.next, node.right);
        }
        
        return false;  // Current node doesn't match, no subpath here
    }
}
