package com.leetcode.algorithms.array;

public class L027_RemoveElement {
	/**
	 * 27. Remove Element
	 * 
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new length.
	 * 
	 * Example: Given input array nums = [3,2,2,3], val = 3
	 * 
	 * Your function should return length = 2, with the first two elements of
	 * nums being 2.
	 * 
	 * Try two pointers. Did you use the property of
	 * "the order of elements can be changed"? What happens when the elements to
	 * remove are rare?
	 * 
	 * Tags: Array Two Pointers
	 * 
	 * 
	 */
	public int removeElement(int[] nums, int val) {
		int len = 0;
		int toIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[toIndex++] = nums[i];
				len++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		L027_RemoveElement solution = new L027_RemoveElement();
		int[] nums = { 3, 2, 2, 1, 4,  3, 6, 7, 3, 1 };
		int len = solution.removeElement(nums, 3);
		for (int i = 0; i < len; i++) {
			System.out.println("nums[" + i + "]=" + nums[i]);
		}
	}

}
