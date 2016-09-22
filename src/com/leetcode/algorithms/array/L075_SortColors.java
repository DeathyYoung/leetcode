package com.leetcode.algorithms.array;

public class L075_SortColors {
	/**
	 * 75. Sort Colors
	 * <p>
	 * Total Accepted: 111777 Total Submissions: 313782 Difficulty: Medium
	 * <p>
	 * Given an array with n objects colored red, white or blue, sort them so
	 * that objects of the same color are adjacent, with the colors in the order
	 * red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively.
	 * 
	 * Note: You are not suppose to use the library's sort function for this
	 * problem.
	 * 
	 * click to show follow up.
	 * 
	 * Tags: Array Two Pointers Sort
	 * 
	 */
	public void sortColors(int[] nums) {
		int[] count = new int[3];
		for (int i : nums) {
			count[i]++;
		}
		int i = 0;
		for (int j = 0; j < count[0]; j++, i++) {
			nums[i] = 0;
		}
		for (int j = 0; j < count[1]; j++, i++) {
			nums[i] = 1;
		}
		for (int j = 0; j < count[2]; j++, i++) {
			nums[i] = 2;
		}
	}

	private void sortColors2(int[] nums) {
		int i = -1;
		int j = -1;
		int k = -1;
		for (int p = 0; p < nums.length; p++) {
			// 根据第i个数字，挪动0~i-1串。
			if (nums[p] == 0) {
				nums[++k] = 2; // 2往后挪
				nums[++j] = 1; // 1往后挪
				nums[++i] = 0; // 0往后挪
			} else if (nums[p] == 1) {
				nums[++k] = 2;
				nums[++j] = 1;
			} else
				nums[++k] = 2;
		}
	}

	private void sortColors3(int[] nums) {
		// 0-----low------mid-------high-----end;
		int n = nums.length;
		int low = 0;
		int mid = 0;
		int high = n - 1;
		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				if(low!=mid){
					nums[low]^=nums[mid];
					nums[mid]^=nums[low];
					nums[low]^=nums[mid];
				}
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				if(high!=mid){
					nums[high]^=nums[mid];
					nums[mid]^=nums[high];
					nums[high]^=nums[mid];
				}
				high--;
				break;
			}
		}
	}

	public static void main(String[] args) {
		L075_SortColors solution = new L075_SortColors();
		int[] nums1 = { 1, 0 };
		solution.sortColors(nums1);
		for (int i : nums1) {
			System.out.println(i);
		}
	}

}
