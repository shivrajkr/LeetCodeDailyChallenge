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
    public void addOneRowRecur(TreeNode root, int val, int depth,int currDepth,boolean gotResult)
    {
        if(root == null)
        {
            return;
        }
        //Base condition
        if(!gotResult && currDepth == depth - 1)
        {
            TreeNode tempLeft=null;
            TreeNode tempRight=null;
            if(root.left!=null)
            {
                 tempLeft = root.left;
            }
            if(root.right!=null)
            {
                tempRight = root.right;
            }
            //TreeNode tempRight = root.right;

            TreeNode newNodeLeft=new TreeNode(val);
            TreeNode newNodeRight=new TreeNode(val);

            root.left = newNodeLeft;
            root.right = newNodeRight;

            if(tempLeft!=null)newNodeLeft.left=tempLeft;
            if(tempRight!=null)newNodeRight.right=tempRight;
            gotResult = true;
            return;
        }
        addOneRowRecur(root.left,val,depth,currDepth+1,gotResult);
        addOneRowRecur(root.right,val,depth,currDepth+1,gotResult);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1)
        {
            TreeNode newNode = new TreeNode(val);
            newNode.left=root;
            return newNode;
        }

        addOneRowRecur(root,val,depth,1,false);
        return root;
    }
}