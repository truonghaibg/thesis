package com.kddcup;

import java.util.Map;
import java.util.Map.Entry;

public class KddCupUtils {
	private static KddCupUtils INSTANCE = new KddCupUtils();

	public static KddCupUtils getInstance() {
		return KddCupUtils.INSTANCE;
	}

	public double searchMin(double min, double value) {
		if (min > value) {
			min = value;
		}
		return min;
	}

	public double searchMax(double max, double value) {
		if (value > max) {
			max = value;
		}
		return max;
	}

	public int fetchUniNumber(double min, double max, int number_of_ranges, double value) {
		double total_length = max - min;
		double subrange_length = total_length / number_of_ranges;
		int result = 0;
		double start = min;
		for (int i = 0; i < number_of_ranges; ++i) {
			double end = start + subrange_length;
			// System.out.println("Smaller range: [" + start + ", " + end +
			// "]");
			if (value >= start && value < end) {
				result = i;
			}
			start += subrange_length;
		}
		// System.out.println(value + ", " + result);
		return result;
	}

	public void putKeyIntoMap(Map<String, Integer> map, String key) {
		Integer value = map.get(key);
		if (value == null) {
			map.put(key, 1);
		} else {
			map.put(key, (value + 1));
		}
	}

	public int countNumber(Map<String, Integer> map) {
		Integer value = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			value = value + entry.getValue();
		}
		return value;
	}
}
