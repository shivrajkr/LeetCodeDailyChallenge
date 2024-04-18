package DailyCodingChalenge;

import java.util.ArrayList;
import java.util.List;

public class Apr17th {
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

	public String smallestFromLeaf(TreeNode root) {
		List<String> strings = new ArrayList<>();
		dfs(root, new StringBuilder(), strings);
		if(strings.isEmpty()) return "";
		System.out.println(strings);
		String result = strings.get(0);
		for(int i=1; i<strings.size(); i++){
			result = lexicographyCompare(result, strings.get(i));
		}

		return result;
	}

	public String lexicographyCompare(String str1, String str2){
		int len = Math.min(str1.length(), str2.length());
		for(int i=0; i<len; i++){
			if(str1.charAt(i) < str2.charAt(i)) return str1;
			if(str1.charAt(i) > str2.charAt(i)) return str2;
		}

		return str1.length() < str2.length() ? str1 : str2;
	}

	public void dfs(TreeNode node, StringBuilder str, List<String> strings)
	{
		if(node == null) return;
		if(node.left == null && node.right == null){
			StringBuilder newStr = new StringBuilder(str);
			newStr.append((char) (node.val + 97));
			strings.add(newStr.reverse().toString());
			return;
		}

		str.append((char) (node.val + 97));
		dfs(node.left, str, strings);
		dfs(node.right, str, strings);
		str.deleteCharAt(str.length()-1);
	}
}
