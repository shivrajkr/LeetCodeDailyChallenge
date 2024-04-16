package DailyCodingChalenge;

import java.util.LinkedList;
import java.util.Queue;

class Apr16th {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if(depth == 1){
			TreeNode node = new TreeNode(val);
			node.left = root;
			return node;
		}

		// DFS
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i = depth;
		while(i > 2){
			int size = queue.size();
			for(int j=0; j<size; j++){
				TreeNode node = queue.remove();
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			i--;
		}

		for(TreeNode t : queue){
			TreeNode leftTemp = t.left;
			TreeNode rightTemp = t.right;
			t.left = new TreeNode(val, leftTemp, null);
			t.right = new TreeNode(val, null, rightTemp);
		}

		return root;
	}
}
