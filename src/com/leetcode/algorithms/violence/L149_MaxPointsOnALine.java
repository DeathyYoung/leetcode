package com.leetcode.algorithms.violence;

import java.util.LinkedHashSet;
import java.util.Set;

import com.leetcode.algorithms.Point;

public class L149_MaxPointsOnALine {
	/**
	 * 149. Max Points on a Line
	 * <p>
	 * Total Accepted: 62986 Total Submissions: 423457 Difficulty: Hard
	 * <p>
	 * Given n points on a 2D plane, find the maximum number of points that lie
	 * on the same straight line.
	 * 
	 * <p>
	 * Tags:Hash Table Math
	 * 
	 */
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;

		LinkedHashSet<Integer>[] setArray = new LinkedHashSet[points.length];
		for (int i = 0; i < points.length; i++) {
			setArray[i] = new LinkedHashSet<Integer>();
		}

		int max = 0;
		for (int i = 0; i + max < points.length; i++) {

			Point now = points[i];
			Set<Integer> checked = new LinkedHashSet<Integer>();
			for (int j = i + 1; j + max - 1 < points.length; j++) {
				if (setArray[i].contains(j)) {
					continue;
				}
				if (checked.contains(j))
					continue;
				Set<Integer> maxSet = new LinkedHashSet<Integer>();
				Point next = points[j];
				maxSet.add(i);
				maxSet.add(j);
				for (int k = j + 1; k < points.length; k++) {
					if ((points[k].y - now.y) * (points[k].x - next.x) == (points[k].y - next.y)
							* (points[k].x - now.x)) {
						setArray[j].add(k);
						maxSet.add(k);
						checked.add(k);
					}
				}
				max = Math.max(maxSet.size(), max);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		L149_MaxPointsOnALine solution = new L149_MaxPointsOnALine();
		int[] nums1 = { 2, 5, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 3, 4 };
		Point[] ps = new Point[10];
		for (int i = 0; i < ps.length; i++) {
			ps[i] = new Point();
			ps[i].x = i * 5 / 3;
			ps[i].y = i * 11 / 8;
			System.out.println("(" + ps[i].x + ", " + ps[i].y + ")");
		}
		System.out.println(solution.maxPoints(ps));
	}

}
