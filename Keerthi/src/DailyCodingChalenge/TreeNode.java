package DailyCodingChalenge;

import java.util.ArrayList;

public class TreeNode
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

class Apr15th
{
	public int sumNumbers(TreeNode root)
	{
		ArrayList<Integer> pathString = new ArrayList<>();
		findPathString(root, 0, pathString);
		int result = 0;
		for(int path : pathString)
			result += path;
		return result;
	}

	public void findPathString(TreeNode node, int path, ArrayList<Integer> pathString)
	{
		if(node == null)
			return;
		path = path * 10 + node.val;
		if(node.left == null && node.right == null)
		{
			pathString.add(path);
			return;
		}
		findPathString(node.left, path, pathString);
		findPathString(node.right, path, pathString);
	}
}
