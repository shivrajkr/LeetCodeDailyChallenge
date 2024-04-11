package DailyCodingChalenge;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Apr11th {
	public static void main(String[] args)
	{
		System.out.println(removeKdigits("1432219", 3));
	}

	public static String removeKdigits(String num, int k) {
		if (num.length() == k)
			return "0";

		StringBuilder sb = new StringBuilder();
		LinkedList<Character> stack = new LinkedList<>();

		for (int i = 0; i < num.length(); ++i) {
			while (k > 0 && !stack.isEmpty() && stack.getLast() > num.charAt(i)) {
				stack.pollLast();
				--k;
			}
			stack.addLast(num.charAt(i));
		}

		while (k-- > 0)
			stack.pollLast();

		for (final char c : stack) {
			if (c == '0' && sb.length() == 0)
				continue;
			sb.append(c);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}
}