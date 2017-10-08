package impl;

import domain.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface Utils {
	public static List<Integer> removeInRange(List<Integer> list, int element, int start, int end) {
		if (list == null) {
			throw new IllegalArgumentException("list cannot be null");
		}

		if (start >= end) {
			throw new IllegalArgumentException("End index should be bigger then start");
		}

		IntStream stream = IntStream.concat(
			IntStream.range(0, start),
			IntStream.concat(
				IntStream.range(start, end).filter(i -> list.get(i) != element),
				IntStream.range(end, list.size())
			)
		);

		return stream.mapToObj(list::get)
			.collect(Collectors.toList());
	}

	public static int countCommon(List<Integer> list1, List<Integer> list2) {
		if (list1 == null || list2 == null) {
			throw new IllegalArgumentException("list cannot be null");
		}

		int result = 0;
		List<Integer> checkedValues = new ArrayList<>();
		for (Integer elem : list1) {
			if (elem != null && !checkedValues.contains(elem) && list2.contains(elem)) {
				checkedValues.add(elem);
				result++;
			}
		}
		return result;
	}

	public static int maxOccurrences(List<Integer> list) {
		if (list == null || list.size() == 0) {
			throw new IllegalArgumentException("list cannot be null or empty");
		}

		ArrayList<Value> values = new ArrayList<>();
		for (Integer elem : list) {
			if (elem != null) {
				Value test = new Value(elem);
				int index = values.indexOf(test);
				if (index != -1) {
					values.get(index).incrementOccurence();
				} else {
					values.add(test);
				}
			}
		}

		Collections.sort(values);
		return values.get(0).getOccurence();
	}
}
