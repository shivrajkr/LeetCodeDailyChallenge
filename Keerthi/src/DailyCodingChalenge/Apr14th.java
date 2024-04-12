package DailyCodingChalenge;

public class Apr14th
{

	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode()
		{
		}

		TreeNode(int val)
		{
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int sumOfLeftLeaves(TreeNode root)
	{
		return sumOfLeftLeaves(root, false);
	}

	public int sumOfLeftLeaves(TreeNode node, boolean isLeft)
	{
		if(node == null)
			return 0;
		if(node.left == null && node.right == null)
		{
			if(isLeft)
				return node.val;
			return 0;
		}
		int result = 0;
		result += sumOfLeftLeaves(node.left, true);
		result += sumOfLeftLeaves(node.right, false);

		return result;
	}
}
