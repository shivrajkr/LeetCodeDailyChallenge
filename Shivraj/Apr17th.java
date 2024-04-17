//https://leetcode.com/problems/smallest-string-starting-from-leaf/submissions/1235020026/?envType=daily-question&envId=2024-04-17

//My solution : TC : O(n) SC : O(mlogm) where n -> Number of nodes and m -> size of the string List
// RunTime : 11ms beats 14.47%
class Solution {
    public void smallestFromLeafRecu(TreeNode root,String str,List<String> result)
    {
        //Base condition
        if(root == null) return;
        if(root.left == null && root.right == null)
        {
            result.add((char)(root.val + 'a')+str);
            return;
        }

        //Main logic
        smallestFromLeafRecu(root.left,(char)(root.val + 'a')+str,result);
        smallestFromLeafRecu(root.right,(char)(root.val + 'a')+str,result);
    }
    public String smallestFromLeaf(TreeNode root) {
        //Edge case - Atleast one node is there
        if(root.left == null && root.right == null)
        {
            int c = root.val + 'a';
            return ""+(char)c;
        }
        List<String> stringList = new ArrayList<>();
        smallestFromLeafRecu(root,"",stringList);
        Collections.sort(stringList);
        return stringList.get(0);
    }
}

//Optimize solution : RunTime : 1ms beats 99%
class Solution {
    String smallestString = null;
    public void dfs(TreeNode root,StringBuilder str)
    {
        //Base case
        if(root == null) return;

        str.append((char)(root.val+'a'));

        //Leaf node check
        if(root.left == null && root.right == null)
        {
            updateSmallestString(str.reverse().toString());
            str.reverse();
        }
        else
        {
            dfs(root.left,str);
            dfs(root.right,str);
        }
        str.deleteCharAt(str.length() - 1);
    }
    public void updateSmallestString(String str)
    {
        if(smallestString == null || str.compareTo(smallestString) < 0)
        {
            smallestString = str;
        }
    }
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,new StringBuilder());
        return smallestString;
    }
}
