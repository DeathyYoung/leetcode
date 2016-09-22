package com.leetcode.algorithms.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU Cache
 * <p>
 * Total Accepted: 82438 Total Submissions: 520571 Difficulty: Hard
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * 
 */
class LRUCache {

	private Map<Integer, Integer> keyIndex;
	private Map<Integer, Integer> indexKey;
	private int[] storeValue;
	private int[] storeTime;

	public LRUCache(int capacity) {
		storeValue = new int[capacity];
		storeTime = new int[capacity];
		keyIndex = new LinkedHashMap<Integer, Integer>();
		indexKey = new LinkedHashMap<Integer, Integer>();
	}

	public int get(int key) {
		Integer index = keyIndex.get(key);
		if (index == null) {
			return -1;
		}
		if (indexKey.get(index) != key) {
			return -1;
		}
		updateTime(index);

		return storeValue[index];
	}

	public void set(int key, int value) {
		Integer index = keyIndex.get(key);
		if (index == null || indexKey.get(index) != key) {
			if (indexKey.size() < storeValue.length) {
				index = indexKey.size();
				indexKey.put(index, key);
				keyIndex.put(key, index);
				storeValue[index] = value;
			} else {
				index = getIndex();
				indexKey.put(index, key);
				keyIndex.put(key, index);
				storeValue[index] = value;
			}
		} else {
			storeValue[index] = value;
		}
		updateTime(index);
	}

	private void updateTime(int index) {
		for (int i = 0; i < storeTime.length; i++) {
			storeTime[i]++;
		}
		storeTime[index] = 0;
	}

	private int getIndex() {
		int index = 0;
		int max = 0;
		for (int i = 0; i < storeTime.length; i++) {
			if (max < storeTime[i]) {
				max = storeTime[i];
				index = i;
			}
		}
		return index;
	}

}

public class L146_LRUCache {
	/**
	 * Design and implement a data structure for Least Recently Used (LRU)
	 * cache. It should support the following operations: get and set.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key
	 * exists in the cache, otherwise return -1. set(key, value) - Set or insert
	 * the value if the key is not already present. When the cache reached its
	 * capacity, it should invalidate the least recently used item before
	 * inserting a new item.
	 */

	public static void main(String[] args) {
		L146_LRUCache solution = new L146_LRUCache();
		// {
		// LRUCache lc = new LRUCache(2);
		// lc.set(2, 1);
		// lc.set(2, 2);
		// System.out.println(lc.get(2));
		// lc.set(1, 1);
		// lc.set(4, 1);
		// System.out.println(lc.get(2));
		// }
		{
			LRUCache lc = new LRUCache(2);
			System.out.println(lc.get(2));
			lc.set(2, 6);
			System.out.println(lc.get(1));
			lc.set(1, 5);
			lc.set(1, 2);
			System.out.println(lc.get(1));
			System.out.println(lc.get(2));
		}
		// 2,[get(2),set(2,6),get(1),set(1,5),set(1,2),get(1),get(2)]
	}
}
