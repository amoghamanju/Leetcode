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
    private Map<Integer,Integer> inordermap;
    private int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inordermap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inordermap.put(inorder[i],i);
        }
        return build(preorder,0, inorder.length-1);
    }
    private TreeNode build(int[] preorder, int left, int right){
        if(left>right) return null;
        int rootval=preorder[preindex++];
        TreeNode root=new TreeNode(rootval);
        int index=inordermap.get(rootval);

        root.left=build(preorder, left,index-1);
        root.right=build(preorder,index+1, right);

        return root;

    }
}
