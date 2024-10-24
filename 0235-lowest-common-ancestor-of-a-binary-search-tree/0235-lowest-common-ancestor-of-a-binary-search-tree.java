/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode head = root;

        while (head != null) {
            if (head.val > p.val && head.val > q.val) {
                // p와 q가 모두 현재 노드보다 작으므로 왼쪽으로 이동
                head = head.left;
            } else if (head.val < p.val && head.val < q.val) {
                // p와 q가 모두 현재 노드보다 크므로 오른쪽으로 이동
                head = head.right;
            } else {
                // p와 q가 각각 다른 쪽에 있거나, 현재 노드가 p 또는 q와 동일한 경우
                return head;
            }
        }
        return null;
    }
}