package MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class Increasing
{
	public static void main(String[] args)
	{
		int[] input = new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
		System.out.println(Arrays.toString(nextSmallerToRight(input)));
		System.out.println(Arrays.toString(nextSmallerToLeft(input)));
	}

	public static int[] nextSmallerToRight(int nums[])
	{
		int[] nextSmaller = new int[nums.length];
		Arrays.fill(nextSmaller, -1);
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<nums.length; i++){
			while(!stack.isEmpty() && nums[stack.peek()] > nums[i])
			{
				int idx = stack.pop();
				nextSmaller[idx] = nums[i];
			}
			stack.push(i);
		}

		return nextSmaller;
	}

	public static int[] nextSmallerToLeft(int nums[])
	{
		int[] nextSmaller = new int[nums.length];
		Arrays.fill(nextSmaller, -1);
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<nums.length; i++){
			while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
			{
				stack.pop();
			}
			if(!stack.isEmpty())
			{
				nextSmaller[i] = nums[stack.peek()];
			}
			stack.push(i);
		}

		return nextSmaller;
	}
}
