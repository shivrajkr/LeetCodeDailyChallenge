package MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class Decreasing
{
	public static void main(String[] args)
	{
		int[] input = new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
		System.out.println(Arrays.toString(nextGreaterToRight(input)));
		System.out.println(Arrays.toString(nextGreaterToLeft(input)));
	}

	public static int[] nextGreaterToRight(int[] nums)
	{
		int[] nextGreater = new int[nums.length];
		Arrays.fill(nextGreater, -1);
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<nums.length; i++){
			while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
				int idx = stack.pop();
				nextGreater[idx] = nums[i];
			}
			stack.push(i);
		}

		return nextGreater;
	}

	public static int[] nextGreaterToLeft(int[] nums)
	{
		int[] nextGreater = new int[nums.length];
		Arrays.fill(nextGreater, -1);
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<nums.length; i++){
			while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
				stack.pop();
			}
			if(!stack.isEmpty())
			{
				nextGreater[i] = nums[stack.peek()];
			}
			stack.push(i);
		}

		return nextGreater;
	}
}
