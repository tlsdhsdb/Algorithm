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
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1 ? true : false;
    }
    private int dfs(TreeNode node){
        if(node == null) return 0; //아무 노드도 없을 경우 높이는 0
        
        int left_h = dfs(node.left);
        if(left_h == -1) return -1;

        int right_h = dfs(node.right);
        if(right_h == -1) return -1;

        if(Math.abs(left_h - right_h) > 1) return -1;
        //높이가 불균형이다

        return Math.max(left_h,right_h) + 1;
    }
}