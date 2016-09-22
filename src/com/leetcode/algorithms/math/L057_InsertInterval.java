package com.leetcode.algorithms.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leetcode.algorithms.Interval;

public class L057_InsertInterval {
	/**
	 * 57. Insert Interval
	 * <p>
	 * Total Accepted: 65545 Total Submissions: 264194 Difficulty: Hard
	 * <p>
	 * Given a set of non-overlapping intervals, insert a new interval into the
	 * intervals (merge if necessary).
	 * 
	 * You may assume that the intervals were initially sorted according to
	 * their start times.
	 * 
	 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
	 * [1,5],[6,9].
	 * 
	 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
	 * in as [1,2],[3,10],[12,16].
	 * 
	 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 * 
	 * <p>
	 * Tags: Array Sort
	 * 
	 */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		return merge(intervals);
	}

	/**
	 * <p>
	 * L056
	 */
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() == 0)
			return intervals;
		List<Interval> list = new ArrayList<Interval>();

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}

		});
		Interval interval = intervals.get(0);
		list.add(interval);
		for (int i = 1; i < intervals.size(); i++) {
			Interval temp = intervals.get(i);
			if (interval.end >= temp.start) {
				interval.end = Math.max(interval.end, temp.end);
			} else {
				interval = temp;
				list.add(interval);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		L057_InsertInterval solution = new L057_InsertInterval();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
	}

}
